package com.example.matchwords.mvc.view.itemdrawer

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.matchwords.mvc.utilities.DataItem


class FalseTextItemDrawer(private val paintText: Paint): IItemDrawer {
    private var previousColor= paintText.color
    //private var previousIsStrikeThrough = paintText.isStrikeThruText
    private val verticalOffsetRatio = 1.5F

    private fun modifyPaint(){
        previousColor= paintText.color
        //previousIsStrikeThrough = paintText.isStrikeThruText

        paintText.color = Color.GREEN
        //paintText.isStrikeThruText = false
    }
    private fun resetPaint(){
        paintText.color=previousColor
        //paintText.isStrikeThruText = previousIsStrikeThrough
    }

    override fun draw(canvas: Canvas?, item: DataItem) {

        if(item.rect != null) {
            val safeRect = item.rect!!
            val fontMetrics=paintText.fontMetrics
            val textVerticalOffset = (fontMetrics.descent - fontMetrics.ascent)/2 - fontMetrics.descent
            canvas?.drawText(item.text,
                safeRect.centerX(),
                safeRect.centerY() + (1+verticalOffsetRatio)* textVerticalOffset  ,
                paintText)

            if(item.correctText!=null){
                modifyPaint()
                canvas?.drawText(item.correctText!!,
                    safeRect.centerX(),
                    safeRect.centerY() + (1-verticalOffsetRatio) * textVerticalOffset ,
                    paintText)
                resetPaint()
            }


        }


    }
}