package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import android.graphics.Paint
import com.example.matchwords.mvc.utilities.MutableDataItem


open class RectangleItemDrawer(private val paint: Paint): IItemDrawer {
    override fun draw(canvas: Canvas?, item: MutableDataItem) {
        item.rect?.let{
            canvas?.drawRect(it,paint)
        }
    }
}

