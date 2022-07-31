package com.example.matchwords.mvc.view.framedtext

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.util.Size
import android.view.MotionEvent
import android.view.View
import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.view.IView

class FramedTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle), IView {
    private var list: List<FramedText>? = null
    private var controller: IController? =null
    private var finished = false




    override fun setController(controller: IController) {
        this.controller=controller
    }

    override fun updateView(list: List<FramedText>?) {
        this.list=list
        this.invalidate()
    }

    override fun getViewSize(): Size {
        return Size(width, height)
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, r, b)
        controller?.updateView()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        controller?.onClick(event!!.x,event.y)
        return super.onTouchEvent(event)
    }



    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        if(list!=null){
            for(framedText in list!!){

                val rect=framedText.frame
                val framedPainter= framedText.framedPainter

                //Background
                canvas?.drawRect(rect, framedPainter.paintBackground )

                //Text
                val text = framedText.text
                val paintText=framedPainter.paintText
                val fontMetrics=paintText.fontMetrics
                val textVerticalOffset = (fontMetrics.descent - fontMetrics.ascent)/2 - fontMetrics.descent
                canvas?.drawText(text,
                    rect.centerX(),
                    rect.centerY() + textVerticalOffset ,
                    paintText)

                //Frame
                 canvas?.drawRect(rect, framedPainter.paintFrame)

            }
        }
    }

}