package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.model.source.ISource

class SwappableModel(source: ISource) : AbstractModel(source) {

    private var modelSelection= SelectionLogic(this)

    override fun onClick(row: Int, column: Int) {
        modelSelection.performSelection(row,column)
    }

    fun swap(row1: Int, row2: Int){
        val temp= itemList[row1][1].text
        itemList[row1][1].text = itemList[row2][1].text
        itemList[row2][1].text = temp

        itemList[row1][0].processed=true
        itemList[row1][1].processed=true
    }
}
class SelectionLogic(private val _swappable: SwappableModel){
    private var selectedRows :Array<Int> = arrayOf(-1,-1)

    fun performSelection(row: Int, column: Int){
        unselectRow(column)
        selectedRows[column]=row
        if(selectedRows[0]!=-1 && selectedRows[1]!=-1){
            _swappable.swap(selectedRows[0],selectedRows[1])
            unselectRow(1)
            unselectRow(0)
            resetSelection()
        }else{
            _swappable.select(selectedRows[column],column,true)
        }
    }
    private fun unselectRow(column: Int){
        _swappable.select( selectedRows[column],column,false)
    }

    private fun resetSelection() {
        selectedRows[0]=-1
        selectedRows[1]=-1
    }


}