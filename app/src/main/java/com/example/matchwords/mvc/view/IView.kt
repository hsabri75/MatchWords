package com.example.matchwords.mvc.view

import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.view.framedtext.FramedText

interface IView {
    fun setController(controller: IController)
    fun updateView(array: List<FramedText>?)
}