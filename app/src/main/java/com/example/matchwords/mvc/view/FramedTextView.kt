package com.example.matchwords.mvc.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.view.framedtext.FramedText

class FramedTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle), IView {
    private var list: List<FramedText>? = null
    private var controller: IController? =null
    private var finished = false
    init{

    }

    override fun setController(controller: IController) {
        this.controller=controller
    }

    override fun updateView(array: List<FramedText>?) {
        this.list=array
        this.invalidate()
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        if(list!=null){
            for(framedText in list!!){

                val rect=framedText.frame

                //Background
                canvas?.drawRect(rect, framedText.paintBackground )

                //Text
                val text = framedText.text
                val textHeight = framedText.paintText.fontMetrics.descent - framedText.paintText.fontMetrics.ascent
                val textVerticalOffset = textHeight/2 - framedText.paintText.fontMetrics.descent
                canvas?.drawText(text,
                    rect.centerX(), rect.centerY() + textVerticalOffset ,
                    framedText.paintText)

                //Frame
                 canvas?.drawRect(rect, framedText.paintFrame)

            }
        }
    }

}