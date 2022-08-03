package com.example.matchwords.mvc.view

import android.graphics.Canvas
import com.example.matchwords.mvc.utilities.DataItem

interface IDrawer{
    fun draw(canvas: Canvas?, item: DataItem)
}

