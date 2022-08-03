package com.example.matchwords.mvc.utilities

import android.graphics.Color
import android.graphics.Paint

class PaintFactory {

    companion object{

        fun selectedBackgroundPaint(): Paint {
            val paintFrame = Paint()
            paintFrame.style = Paint.Style.FILL
            paintFrame.color = Color.YELLOW
            return paintFrame
        }

        fun selectedTextPaint(): Paint {
            val paintText = Paint()
            paintText.style = Paint.Style.FILL
            paintText.color = Color.BLACK
            paintText.textSize = 70F
            paintText.textAlign = Paint.Align.CENTER
            return paintText
        }

        fun textPaint(): Paint {
            val paintText = Paint()
            paintText.style = Paint.Style.FILL
            paintText.color = Color.BLACK
            paintText.textSize = 40F
            paintText.textAlign = Paint.Align.CENTER
            return paintText
        }

        fun framePaint(): Paint {
            val paintFrame = Paint()
            paintFrame.style = Paint.Style.STROKE
            paintFrame.color = Color.BLACK
            paintFrame.strokeWidth = 5F
            return paintFrame
        }
    }

}