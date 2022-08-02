package com.example.matchwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.matchwords.databinding.ActivityMainBinding
import com.example.matchwords.mvc.controller.Controller
import com.example.matchwords.mvc.controller.layout.GridLayout

import com.example.matchwords.mvc.model.SwappableModel
import com.example.matchwords.mvc.model.source.RandomFilteredSource
import com.example.matchwords.mvc.model.source.SampleSource
import com.example.matchwords.mvc.view.FramedPainter
import com.example.matchwords.mvc.view.IDrawer
import com.example.matchwords.mvc.view.drawer.BorderDrawer
//import com.example.matchwords.mvc.view.drawer.BorderDrawer
import com.example.matchwords.mvc.view.drawer.RectangleDrawer
import com.example.matchwords.mvc.view.drawer.TextDrawer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.framedText.updateView(getTestFramedText())
         */
        val selectionPainter= FramedPainter.defaultSelectionPainter()
        selectionPainter.paintFrame.strokeWidth = 5F

        val layers= mutableListOf<IDrawer>()
        layers.add(TextDrawer())
        layers.add(BorderDrawer())

        val layersSelected= mutableListOf<IDrawer>()
        layersSelected.add(RectangleDrawer(selectionPainter.paintBackground))
        layersSelected.add(TextDrawer(selectionPainter.paintText))
        layersSelected.add(RectangleDrawer(selectionPainter.paintFrame))

        val layersFalse= mutableListOf<IDrawer>()
        layersFalse.add(TextDrawer(FramedPainter.strikethroughTextPainter()))

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val simpleView = binding.simpleView
        val model= SwappableModel(RandomFilteredSource(SampleSource(),6))
        val layout= GridLayout()
        val controller= Controller(simpleView, model, layout, layers, layersSelected, layersFalse)

        binding.button.setOnClickListener {
            controller.check()
            //binding.button.text="new game"
            //simpleView.updateView()
        }
    }




/*
    private fun getTestFramedText(): List<FramedText>{
        val blueThickFrame = FramedPainter.defaultFramePaint()
        blueThickFrame.color =Color.BLUE
        blueThickFrame.strokeWidth = 10F

        val yellowBackground = FramedPainter.defaultBackgroundPaint()
        yellowBackground.color =Color.YELLOW

        val largeText = FramedPainter.defaultTextPaint()
        largeText.color = Color.RED
        largeText.textSize = 100F

        val list= mutableListOf<FramedText>()
        list.add( FramedText(
            "Default Style"
            , RectF(20F,20F,500F,100F)
        )
        )
        list.add( FramedText(
            "Custom Frame"
            , RectF(70F,200F,600F,300F)
            , FramedPainter( paintFrame = blueThickFrame)
        )
        )
        list.add( FramedText(
            "Custom Background"
            , RectF(30F,400F,500F,500F)
            , FramedPainter( paintBackground = yellowBackground)
        )
        )
        list.add( FramedText(
            "Custom Frame and Background"
            , RectF(70F,600F,700F,700F)
            , FramedPainter( paintFrame = blueThickFrame, paintBackground = yellowBackground)
        )
        )
        list.add( FramedText(
            "Custom Font"
            , RectF(10F,800F,1000F,950F)
            , FramedPainter( paintText =  largeText)
        )
        )
        return list
    }
*/

}