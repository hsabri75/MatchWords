package com.example.matchwords.mvc.view

import android.graphics.Point
import android.util.Size
import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.view.framedtext.FramedText

interface IView {
    fun setController(controller: IController)
    fun updateView(list: List<FramedText>?)
    fun getViewDimensionsHeight() : Size
}