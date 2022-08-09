package com.example.matchwords.mvc.controller.layout

import android.graphics.RectF
import android.util.Size
import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.utilities.MutableDataItem


class GridLayout(): ILayout {

    override fun place(model: IModel,size: Size) {
        val calcWidth = size.width * fillRatio
        val calcHeight = size.height * fillRatio
        (0 until model.getRowCount()).forEach{ row ->
            (0 until model.getColumnCount()).forEach{column ->
                val dataItem = model.getItem(row,column)
                val processEffect= if(dataItem.processed) 1 else 0
                val sign = (if (column==0) 1 else -1)
                val x0 = (column    + 0.5F - fillRatio/2) * size.width + sign * processEffect * (size.width * (1-fillRatio) )/2
                val y0 = (row       + 0.5F - fillRatio/2) * size.height
                if(dataItem.rect == null){
                    dataItem.rect = RectF( x0, y0, x0+ calcWidth, y0+calcHeight )
                }else{
                    with(dataItem.rect!!){
                        left = x0
                        top = y0
                        right = x0 + calcWidth
                        bottom = y0 + calcHeight
                    }
                }

            }

        }
    }


    override fun getIndexFromPosition(x: Float, y: Float, size: Size): Pair<Int, Int> {
        val row = (y/size.height).toInt()
        val column= (x/size.width).toInt()
        return Pair(row,column)
    }



    companion object{
        const val fillRatio = 0.8F
    }
}