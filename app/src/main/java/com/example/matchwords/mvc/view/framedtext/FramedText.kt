package com.example.matchwords.mvc.view.framedtext

import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF


class FramedText(
    var text: String
    ,var frame: RectF
    ,var paintBackground: Paint = defaultPaintBackground()
    ,var paintText: Paint = defaultPaintText()
    ,var paintFrame: Paint = defaultPaintFrame() ){

    companion object{

        fun defaultPaintBackground(): Paint{
            val paintBackground = Paint()
            paintBackground.style = Paint.Style.FILL
            paintBackground.color = Color.WHITE
            return paintBackground
        }

        fun defaultPaintText(): Paint{
            val paintText = Paint()
            paintText.style = Paint.Style.FILL
            paintText.color = Color.BLACK
            paintText.textSize = 40F
            paintText.textAlign = Paint.Align.CENTER
            return paintText
        }
        fun defaultPaintFrame(): Paint{
            val paintFrame = Paint()
            paintFrame.style = Paint.Style.STROKE
            paintFrame.color = Color.BLACK
            paintFrame.strokeWidth = 5F
            return paintFrame
        }
    }

}

