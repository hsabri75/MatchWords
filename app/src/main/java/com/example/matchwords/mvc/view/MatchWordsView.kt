package com.example.matchwords.mvc.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Size
import android.view.MotionEvent
import android.view.View
import com.example.matchwords.mvc.controller.IController


class MatchWordsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle), IView {
    private var controller: IController? =null

    override fun setController(controller: IController) {
        this.controller=controller
    }

    override fun updateView() {
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
        controller?.draw(canvas)
    }

}