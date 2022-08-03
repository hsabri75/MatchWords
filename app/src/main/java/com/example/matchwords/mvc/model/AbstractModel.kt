package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.model.source.ISource
import com.example.matchwords.mvc.utilities.DataItem

abstract class AbstractModel(source: ISource) : IModel {
    private val sourceData=source.getSourceData()
    protected val itemList= (sourceData.map {arr -> (arr.map { str -> DataItem(str) }).toTypedArray() }).toTypedArray()
    private var _controller: IController? =null

    override fun select(row: Int, column: Int, isSelected: Boolean) {
        if(row>=0){
            if(column>=0){
                itemList[row][column].selected=isSelected
            }
            _controller?.updateView()
        }
    }

    override fun setController(controller: IController) {
        this._controller = controller
    }

    override fun getArray(): Array<Array<DataItem>> {
        return itemList
    }

    override fun shuffle() {
        val shuffled = (itemList.indices).shuffled()

        itemList.forEachIndexed() {index, arrayOfDataItems ->
            arrayOfDataItems[1].text = sourceData[shuffled[index]][1]
            arrayOfDataItems[1].correctText = sourceData[index][1]
        }
    }

    protected fun selectAll(selected:Boolean){
        itemList.forEach { it.forEach { item -> item.selected=selected } }
    }
/*
    override fun check() : Array<Boolean> {
        selectAll(false)
        //val correctList= Array(itemList.size) { false }

        itemList.forEachIndexed() { index, arrayOfDataItems ->
            correctList[index] = arrayOfDataItems[1].text == sourceData[index][1]
        }
        return correctList
    }
 */


}