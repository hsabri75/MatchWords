package com.example.matchwords

import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.matchwords.databinding.ActivityMainBinding
import com.example.matchwords.mvc.view.FramedTextView
import com.example.matchwords.mvc.view.framedtext.FramedText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val framedText = binding.framedText


        framedText.updateView(getTestFramedText())



    }

    private fun getTestFramedText(): List<FramedText>{
        val blueThickFrame = FramedText.defaultPaintFrame()
        blueThickFrame.color =Color.BLUE
        blueThickFrame.strokeWidth = 10F

        val yellowBackground = FramedText.defaultPaintBackground()
        yellowBackground.color =Color.YELLOW

        val largeText = FramedText.defaultPaintText()
        largeText.color = Color.RED
        largeText.textSize = 100F

        val list= mutableListOf<FramedText>()
        list.add( FramedText(
            "Default Style"
            , RectF(20F,20F,500F,100F)
        ))
        list.add( FramedText(
            "Custom Frame"
            , RectF(70F,200F,600F,300F)
            , paintFrame = blueThickFrame
        ))
        list.add( FramedText(
            "Custom Background"
            , RectF(30F,400F,500F,500F)
            , paintBackground = yellowBackground
        ))
        list.add( FramedText(
            "Custom Frame and Background"
            , RectF(70F,600F,700F,700F)
            , paintFrame = blueThickFrame
            , paintBackground = yellowBackground
        ))
        list.add( FramedText(
            "Custom Font"
            , RectF(10F,800F,1000F,950F)
            , paintText =  largeText
        ))
        return list
    }
}