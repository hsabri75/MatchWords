package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import android.graphics.Paint
import com.example.matchwords.mvc.utilities.MutableDataItem
import com.example.matchwords.mvc.utilities.TextPaint


class TextItemDrawer(private val paintText: Paint = TextPaint()): IItemDrawer {
    override fun draw(canvas: Canvas?, item: MutableDataItem) {
        item.rect?.let {
            val fontMetrics = paintText.fontMetrics
            val textVerticalOffset =
                (fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent
            canvas?.drawText(item.text,
                it.centerX(),it.centerY() + textVerticalOffset,
                paintText
            )
        }
    }

}

