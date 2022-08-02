package com.example.matchwords.mvc.view

import android.util.Size
import com.example.matchwords.mvc.controller.IController

interface IView {
    fun setController(controller: IController)
    fun updateView()
    fun getViewSize() : Size
}