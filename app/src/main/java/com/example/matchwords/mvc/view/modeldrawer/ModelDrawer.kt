package com.example.matchwords.mvc.view.modeldrawer


import android.graphics.Canvas
import android.graphics.Color

import com.example.matchwords.mvc.model.IModel

import com.example.matchwords.mvc.utilities.*
import com.example.matchwords.mvc.view.itemdrawer.IItemDrawer
import com.example.matchwords.mvc.view.itemdrawer.BorderItemDrawer
import com.example.matchwords.mvc.view.itemdrawer.FalseTextItemDrawer
import com.example.matchwords.mvc.view.itemdrawer.RectangleItemDrawer
import com.example.matchwords.mvc.view.itemdrawer.TextItemDrawer

class ModelDrawer(
    private val unSelectedDrawer: MutableList<IItemDrawer> =mutableListOf<IItemDrawer>().also{
        it.add(TextItemDrawer())
        it.add(BorderItemDrawer())                                    },
    private val selectedDrawer: MutableList<IItemDrawer> =mutableListOf<IItemDrawer>().also{
            it.add(RectangleItemDrawer(SelectedBackgroundPaint()))
            it.add(TextItemDrawer(SelectedTextPaint()))
            it.add(RectangleItemDrawer(FramePaint()))
    },
    private val correctDrawer: MutableList<IItemDrawer> =mutableListOf<IItemDrawer>().also {
        it.add(TextItemDrawer(TextPaint(color= Color.GREEN)))
        it.add(BorderItemDrawer(FramePaint(color=Color.GREEN)))
    },
    private val incorrectDrawer: MutableList<IItemDrawer> =mutableListOf<IItemDrawer>().also{
        it.add(FalseTextItemDrawer( TextPaint(color=Color.RED)))
        it.add(BorderItemDrawer(FramePaint(color=Color.RED)))

    }): IModelDrawer
{
    override fun draw(canvas: Canvas?, model: IModel, isFinished: Boolean){
        model.getArray().forEach {arrayItem ->
            if(!isFinished) {
                arrayItem.forEachIndexed { index, dataItem ->
                    val list = if (dataItem.selected) selectedDrawer else unSelectedDrawer
                    list.forEach { it.draw(canvas, dataItem) }
                }
            }else{
                val dataItem =arrayItem[1]
                if(dataItem.text== dataItem.correctText ){
                    correctDrawer.forEach { it.draw(canvas, dataItem)}
                    correctDrawer.forEach{ it.draw(canvas, arrayItem[0])}
                }else{
                    incorrectDrawer.forEach { it.draw(canvas, dataItem)}
                    incorrectDrawer.forEach{ it.draw(canvas, arrayItem[0])}
                }
            }
        }
    }

}