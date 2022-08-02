package com.example.matchwords.mvc.view.drawer

import android.graphics.Canvas
import android.graphics.Paint
import com.example.matchwords.mvc.model.DataItem
import com.example.matchwords.mvc.view.FramedPainter
import com.example.matchwords.mvc.view.IDrawer

open class RectangleDrawer(private val paint: Paint): IDrawer {
    override fun draw(canvas: Canvas?, item: DataItem) {
        if(item.rect != null) {
            val safeRect = item.rect!!
            canvas?.drawRect(safeRect, paint)
        }
    }
}

//class BackgroundDrawer(private val paint: Paint= FramedPainter.defaultBackgroundPaint()): RectangleDrawer(paint)
class BorderDrawer(private val paint: Paint= FramedPainter.defaultFramePaint()): RectangleDrawer(paint)