package com.example.matchwords.mvc.view

import android.graphics.Canvas
import com.example.matchwords.mvc.model.DataItem

interface IDrawer{
    fun draw(canvas: Canvas?, item: DataItem)
}

