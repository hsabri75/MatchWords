package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.controller.IController
import com.example.matchwords.mvc.model.source.ISource

class Model(source: ISource) : IModel {
    private var data:Array<Array<String>> = source.getSourceData()
    private var isProcessed= Array(data.size) { _ -> false }
    private var modelSelection= RowSelection()

    private var controller: IController? =null

    override fun select(row: Int, column: Int) {
        if(modelSelection.needSwap(row,column)){
            val (row1,row2) = modelSelection.getSelectedRows()
            swap(row1,row2)
            modelSelection.resetSelection()
            isProcessed[row1]=true
        }
        controller?.updateView()
    }

    private fun swap(row1: Int, row2: Int){
        val temp= data[row1][1]
        data[row1][1] = data[row2][1]
        data[row2][1] = temp
    }

    override fun setController(controller: IController) {
        this.controller=controller
    }

    override fun getData(): Array<Array<String>> {
        return data
    }

    override fun isProcessed(): Array<Boolean> {
        return isProcessed
    }

    override fun getSelection(): Pair<Int, Int> {
        return modelSelection.getSelectedCell()// Pair(selRow,selColumn)
    }
}

class RowSelection{
    private var selection :Array<Int> = arrayOf(-1,-1)
    fun needSwap(row: Int, column: Int) : Boolean{
        selection[column]=row
        return (selection[0]!=-1 && selection[1]!=-1)
    }

    fun getSelectedRows(): Array<Int> {
        return selection
    }

    fun getSelectedCell(): Pair<Int,Int>{
        return if(selection[0]==-1){
            selection[1] to 1
        }else{
            selection[0] to 0
        }
    }

    fun resetSelection() {
        selection[0]=-1
        selection[1]=-1
    }


}