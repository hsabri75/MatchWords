package com.example.matchwords.mvc.view.framedtext

import android.graphics.Color
import android.graphics.Paint

open class FramedPainter(var paintBackground: Paint = defaultBackgroundPaint()
                    ,var paintText: Paint = defaultTextPaint()
                    ,var paintFrame: Paint = defaultFramePaint())
{
    companion object{

        fun defaultSelectionPainter(): FramedPainter{
            val paintBG= defaultBackgroundPaint()
            paintBG.color=Color.YELLOW
            val paintText= defaultTextPaint()
            paintText.textSize =70F
            return FramedPainter(paintBackground = paintBG, paintText=paintText)
        }

        fun defaultBackgroundPaint(): Paint{
            val paintBackground = Paint()
            paintBackground.style = Paint.Style.FILL
            paintBackground.color = Color.WHITE
            return paintBackground
        }

        fun defaultTextPaint(): Paint{
            val paintText = Paint()
            paintText.style = Paint.Style.FILL
            paintText.color = Color.BLACK
            paintText.textSize = 40F
            paintText.textAlign = Paint.Align.CENTER
            return paintText
        }
        fun defaultFramePaint(): Paint{
            val paintFrame = Paint()
            paintFrame.style = Paint.Style.STROKE
            paintFrame.color = Color.BLACK
            paintFrame.strokeWidth = 5F
            return paintFrame
        }
    }
}