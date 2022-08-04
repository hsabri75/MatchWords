package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import com.example.matchwords.mvc.utilities.DataItem

interface IItemDrawer{
    fun draw(canvas: Canvas?, item: DataItem)
}

