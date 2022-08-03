package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.model.source.ISource

open class SimpleSelectionModel(source: ISource) : AbstractModel(source) {

    override fun onClick(row: Int, column: Int) {
        select( row, column, !itemList[row][column].selected )
    }



}