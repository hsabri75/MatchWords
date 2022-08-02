package com.example.matchwords.mvc.controller.layout

import android.graphics.RectF
import android.util.Size
import com.example.matchwords.mvc.model.DataItem


class GridLayout: ILayout {
    private val fillRatio = 0.8F
    override fun place(array: Array<Array<DataItem>>, size: Size) {
        val calcWidth = size.width * fillRatio
        val calcHeight = size.height * fillRatio
        array.forEachIndexed{ row, arr ->
            arr.forEachIndexed{ column, dataItem ->
                val processEffect= if(dataItem.processed) 1 else 0
                val sign = (if (column==0) 1 else -1)
                val x0 = (column    + 0.5F - fillRatio/2) * size.width + sign * processEffect * (size.width * (1-fillRatio) )/2
                val y0 = (row       + 0.5F - fillRatio/2) * size.height
                dataItem.rect=RectF( x0, y0, x0+ calcWidth, y0+calcHeight )
            }
        }
    }

    override fun getIndexFromPosition(x: Float, y: Float, size: Size): Pair<Int, Int> {
        val row = (y/size.height).toInt()
        val column= (x/size.width).toInt()
        return Pair(row,column)
    }
}