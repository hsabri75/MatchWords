package com.example.matchwords.mvc.controller.layout

import android.util.Size
import com.example.matchwords.mvc.model.DataItem

interface ILayout {
    fun place(array: Array<Array<DataItem>>, size: Size)
    fun getIndexFromPosition(x: Float, y: Float, size: Size): Pair<Int, Int>

}