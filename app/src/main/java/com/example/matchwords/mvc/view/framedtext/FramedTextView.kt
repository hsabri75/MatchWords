package com.example.matchwords.mvc.view.framedtext

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.util.Size
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
    init{

    }
    var myWidth:Int? =null
    var myHeight:Int? =null

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        myWidth = width
        myHeight = height
    }

    override fun setController(controller: IController) {
        this.controller=controller
    }

    override fun updateView(list: List<FramedText>?) {
        this.list=list
        this.invalidate()
    }

    override fun getViewDimensionsHeight(): Size {
        return Size(width, height)
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, r, b)
        Log.d("HSA", "Layout $l  $t $r $b $myWidth $myHeight" )
        controller?.updateView()
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