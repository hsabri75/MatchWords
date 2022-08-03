package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.utilities.DataItem

interface IModel {
    fun select(row: Int, column: Int, isSelected: Boolean)
    fun onClick(row: Int, column: Int)
    fun setController(controller: IController)
    fun getArray(): Array<Array<DataItem>>
    fun shuffle()
    //fun check(): Array<Boolean>



}