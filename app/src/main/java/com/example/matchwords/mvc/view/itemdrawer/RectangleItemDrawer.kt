package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import android.graphics.Paint
import com.example.matchwords.mvc.utilities.DataItem


open class RectangleItemDrawer(private val paint: Paint): IItemDrawer {
    override fun draw(canvas: Canvas?, item: DataItem) {
        if(item.rect != null) {
            val safeRect = item.rect!!
            canvas?.drawRect(safeRect, paint)
        }
    }
}

