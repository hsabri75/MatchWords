package com.example.matchwords.mvc.controller.layout

import android.util.Size
import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.utilities.MutableDataItem

interface ILayout {
    //fun place(array: Array<Array<MutableDataItem>>, size: Size)
    fun getIndexFromPosition(x: Float, y: Float, size: Size): Pair<Int, Int>
    fun place(model: IModel, size: Size)

}