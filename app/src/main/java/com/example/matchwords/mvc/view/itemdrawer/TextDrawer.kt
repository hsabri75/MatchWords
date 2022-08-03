package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import android.graphics.Paint
import com.example.matchwords.mvc.utilities.DataItem
import com.example.matchwords.mvc.utilities.PaintFactory
import com.example.matchwords.mvc.view.IDrawer
import com.example.matchwords.mvc.view.modeldrawer.ModelDrawer

class TextDrawer(private val paintText: Paint = PaintFactory.textPaint()): IDrawer {
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

