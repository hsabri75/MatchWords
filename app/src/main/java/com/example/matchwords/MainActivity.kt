package com.example.matchwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.matchwords.databinding.ActivityMainBinding
import com.example.matchwords.mvc.controller.Controller
import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.controller.layout.GridLayout
import com.example.matchwords.mvc.controller.layout.ILayout
import com.example.matchwords.mvc.model.IModel

import com.example.matchwords.mvc.model.SwappableModel
import com.example.matchwords.mvc.model.source.*
import com.example.matchwords.mvc.view.modeldrawer.IModelDrawer
import com.example.matchwords.mvc.view.modeldrawer.ModelDrawer



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isPlaying=false
    private var controller: IController?=null
    private var questionCount=16
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerGroup= ModelDrawer()
        val layout= GridLayout()

        binding.button.setOnClickListener {
            if(isPlaying){
                val correctCount= controller?.check()
                Toast.makeText(this@MainActivity, "$correctCount / $questionCount", Toast.LENGTH_LONG).show()
                binding.button.text= resources.getString(R.string.new_game)
                isPlaying=false
            }else{
                //val source= SampleSource()
                val source= RandomFilteredSource(CapitalSource(),questionCount)
                questionCount = source.getSourceData().size
                newGame(drawerGroup,layout, source)
                binding.button.text=resources.getString(R.string.check_words)
                isPlaying=true
            }
        }
    }

    private fun newGame(drawerGroup: IModelDrawer, layout: ILayout,source: ISource){
        val model= SwappableModel(source)
        controller= Controller(binding.matchWordsView, model, layout, drawerGroup)
    }




}