package com.example.matchwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.matchwords.databinding.ActivityMainBinding
import com.example.matchwords.mvc.controller.Controller
import com.example.matchwords.mvc.controller.layout.GridLayout

import com.example.matchwords.mvc.model.SwappableModel
import com.example.matchwords.mvc.model.source.RandomFilteredSource
import com.example.matchwords.mvc.model.source.ShortRussianSource
import com.example.matchwords.mvc.view.modeldrawer.ModelDrawer



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val drawerGroup= ModelDrawer()
       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val simpleView = binding.simpleView
        val model= SwappableModel(RandomFilteredSource(ShortRussianSource(),8))
        val layout= GridLayout()
        val controller= Controller(simpleView, model, layout, drawerGroup )

        binding.button.setOnClickListener {
            controller.check()

        }
    }




}