package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.model.source.ISource
import com.example.matchwords.mvc.utilities.MutableDataItem


abstract class AbstractModel(source: ISource) : IModel {
    private val sourceData=source.getSourceData()
    protected val itemList= (sourceData.map {arr -> (arr.map { str -> MutableDataItem(str, correctText = null) }).toTypedArray() }).toTypedArray()
    private var _controller: IController? =null

    fun select(row: Int, column: Int, isSelected: Boolean) {
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

    override fun getItem(row: Int, column: Int):MutableDataItem = itemList[row][column]

    override fun getRowCount() : Int = itemList.size

    override fun getColumnCount(): Int = itemList[0].size


    override fun shuffle() {
        val shuffled = (itemList.indices).shuffled()

        itemList.forEachIndexed() {index, arrayOfDataItems ->
            arrayOfDataItems[1].text = sourceData[shuffled[index]][1]
            arrayOfDataItems[1].correctText = sourceData[index][1]
        }
    }


}