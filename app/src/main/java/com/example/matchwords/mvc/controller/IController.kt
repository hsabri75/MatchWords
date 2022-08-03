package com.example.matchwords.mvc.controller

import android.graphics.Canvas

interface IController {
    fun updateView()
    fun onClick(x: Float, y: Float)
    fun draw(canvas: Canvas?)
    fun check():Int

}