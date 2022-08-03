package com.example.matchwords.mvc.view.modeldrawer


import android.graphics.Canvas
import android.graphics.Color

import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.utilities.PaintFactory
import com.example.matchwords.mvc.view.IDrawer
import com.example.matchwords.mvc.view.itemdrawer.BorderDrawer
import com.example.matchwords.mvc.view.itemdrawer.FalseTextDrawer
import com.example.matchwords.mvc.view.itemdrawer.RectangleDrawer
import com.example.matchwords.mvc.view.itemdrawer.TextDrawer

class ModelDrawer(
    private val unSelectedDrawer: MutableList<IDrawer> =mutableListOf<IDrawer>().also{
                            it.add(TextDrawer())
                            it.add(BorderDrawer())                                    },
    private val selectedDrawer: MutableList<IDrawer> =mutableListOf<IDrawer>().also{
        with(PaintFactory){
            it.add(RectangleDrawer(selectedBackgroundPaint()))
            it.add(TextDrawer(selectedTextPaint()))
            it.add(RectangleDrawer(framePaint()))
        }
                                                    },
    private val correctDrawer: MutableList<IDrawer> =mutableListOf<IDrawer>().also {
                             it.add(TextDrawer(PaintFactory.textPaint().also{
                                     paint -> paint.color = Color.GREEN
                             }))
                         },
    private val incorrectDrawer: MutableList<IDrawer> =mutableListOf<IDrawer>().also{
                             it.add(
                                 FalseTextDrawer(
                                     PaintFactory.textPaint().also { paint ->
                                         paint.color = Color.RED
                                         paint.isStrikeThruText=true
                                     })
                             )
                         }): IModelDrawer
 {
    override fun draw(canvas: Canvas?, model: IModel, isFinished: Boolean){
        model.getArray().forEach {arrayItem ->
            arrayItem.forEachIndexed { index, dataItem ->
                if(!isFinished){
                    val list = if (dataItem.selected) selectedDrawer else unSelectedDrawer
                    list.forEach { it.draw(canvas, dataItem)}
                }else{
                    if(index==0){
                        unSelectedDrawer.forEach{ it.draw(canvas, dataItem)}
                    } else{
                        val list = if (dataItem.text== dataItem.correctText ) correctDrawer else incorrectDrawer
                        list.forEach { it.draw(canvas, dataItem)}
                    }
                }
            }
        }
    }

}