package com.example.matchwords.mvc.view.modeldrawer


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

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
        it.add(
            BorderDrawer(PaintFactory.framePaint().also { paint -> paint.color=Color.GREEN })
        )
    },
    private val incorrectDrawer: MutableList<IDrawer> =mutableListOf<IDrawer>().also{
        it.add(
            FalseTextDrawer(
                PaintFactory.textPaint().also { paint ->
                    paint.color = Color.RED
                    //paint.isStrikeThruText=true
                }))
        it.add(
            BorderDrawer(PaintFactory.framePaint().also { paint -> paint.color=Color.RED })
        )
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
                //unSelectedDrawer.forEach{ it.draw(canvas, arrayItem[0])}


            }
        }
    }

}