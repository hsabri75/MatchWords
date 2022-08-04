package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import android.graphics.Paint
import com.example.matchwords.mvc.utilities.DataItem
import com.example.matchwords.mvc.utilities.TextPaint


class TextItemDrawer(private val paintText: Paint = TextPaint()): IItemDrawer {
    override fun draw(canvas: Canvas?, item: DataItem) {
        if(item.rect != null) {
            val safeRect = item.rect!!
            val fontMetrics=paintText.fontMetrics
            val textVerticalOffset = (fontMetrics.descent - fontMetrics.ascent)/2 - fontMetrics.descent
            canvas?.drawText(item.text,
                safeRect.centerX(),
                safeRect.centerY() + textVerticalOffset ,
                paintText)
        }
    }
}

