package com.example.matchwords.mvc.view.drawer

import android.graphics.Canvas
import android.graphics.Paint
import com.example.matchwords.mvc.model.DataItem
import com.example.matchwords.mvc.view.FramedPainter
import com.example.matchwords.mvc.view.IDrawer

class TextDrawer(private val paintText: Paint = FramedPainter.defaultTextPaint()): IDrawer {
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

class FalseTextDrawer(private val paintText: Paint = FramedPainter.defaultTextPaint()): IDrawer {
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