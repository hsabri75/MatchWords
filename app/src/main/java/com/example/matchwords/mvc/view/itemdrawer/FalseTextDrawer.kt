package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.matchwords.mvc.utilities.DataItem
import com.example.matchwords.mvc.view.IDrawer

class FalseTextDrawer(private val paintText: Paint): IDrawer {
    private var previousColor= paintText.color
    private var previousIsStrikeThrough = paintText.isStrikeThruText
    private val verticalOffsetRatio = 4

    private fun modifyPaint(){
        previousColor= paintText.color
        previousIsStrikeThrough = paintText.isStrikeThruText

        paintText.color = Color.GREEN
        paintText.isStrikeThruText = false
    }
    private fun resetPaint(){
        paintText.color=previousColor
        paintText.isStrikeThruText = previousIsStrikeThrough
    }

    override fun draw(canvas: Canvas?, item: DataItem) {

        if(item.rect != null) {
            val safeRect = item.rect!!
            val fontMetrics=paintText.fontMetrics
            val textVerticalOffset = (fontMetrics.descent - fontMetrics.ascent)/2 - fontMetrics.descent
            canvas?.drawText(item.text,
                safeRect.centerX(),
                safeRect.top +  verticalOffsetRatio*textVerticalOffset ,
                paintText)
            modifyPaint()
            canvas?.drawText(item.correctText!!,
                safeRect.centerX(),
                safeRect.bottom -  verticalOffsetRatio*textVerticalOffset ,
                paintText)
            resetPaint()
        }


    }
}