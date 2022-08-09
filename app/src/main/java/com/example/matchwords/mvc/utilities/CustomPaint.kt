package com.example.matchwords.mvc.utilities

import android.graphics.Color
import android.graphics.Paint

open class CustomPaint(color: Int=Color.BLACK,
                     style: Style= Style.FILL,
                     textSize: Float= 40F )
    :Paint() {
    init{
        this.color =color
        this.style = style
        this.textSize = textSize
        this.strokeWidth
        textAlign = Align.CENTER
    }
}
class TextPaint(color: Int=Color.BLACK,
                        style: Style= Style.FILL,
                        textSize: Float= 40F )
    : CustomPaint(color, style, textSize)

class SelectedTextPaint(color: Int=Color.BLACK,
                        style: Style= Style.FILL,
                        textSize: Float= 70F )
    : CustomPaint(color, style, textSize)

class SelectedBackgroundPaint(color: Int=Color.YELLOW,
                                style: Style= Style.FILL)
    : CustomPaint(color, style)

class FramePaint(color: Int=Color.BLACK,
                 style: Style= Style.STROKE,
                _strokeWidth: Float = 5F)
    : CustomPaint(color, style){
        init{
            this.strokeWidth=_strokeWidth
        }
    }

