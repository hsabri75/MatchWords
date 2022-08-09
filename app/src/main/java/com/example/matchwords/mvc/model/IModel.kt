package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.utilities.MutableDataItem

interface IModel {

    fun onClick(row: Int, column: Int)
    fun setController(controller: IController)
    fun getItem(row: Int, column: Int): MutableDataItem
    fun shuffle()
    fun getRowCount(): Int
    fun getColumnCount(): Int

}