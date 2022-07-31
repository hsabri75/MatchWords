package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.controller.IController

interface IModel {
    fun select(row: Int, column: Int)
    fun setController(controller: IController)
    fun getData(): Array<Array<String>>
    fun isProcessed(): Array<Boolean>
    fun getSelection(): Pair<Int,Int>

}