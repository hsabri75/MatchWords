package com.example.matchwords.mvc.view.modeldrawer

import android.graphics.Canvas
import com.example.matchwords.mvc.model.IModel

interface IModelDrawer {
    fun draw(canvas: Canvas?, model: IModel, isFinished: Boolean)
}