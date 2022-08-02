package com.example.matchwords.mvc.controller

import android.graphics.Canvas
import android.util.Size
import com.example.matchwords.mvc.controller.layout.ILayout
import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.view.IDrawer
import com.example.matchwords.mvc.view.IView


class Controller (private val view: IView
                  , private val model: IModel
                  , private val layout: ILayout
                  , private val layers: List<IDrawer>
                  , private val layersSelected: List<IDrawer>
                  , private val layersFalse: List<IDrawer>
): IController {
    private var frameSize: Size? =null
    private var isFinished=false

    init{
        view.setController(this)
        model.setController(this)
        model.shuffle()
    }
    override fun updateView(){
        if(frameSize==null){
            frameSize=Size(view.getViewSize().width / model.getArray()[0].size,
                view.getViewSize().height / model.getArray().size)
        }
        view.updateView()
    }

    override fun onClick(x: Float, y: Float) {
        if(!isFinished){
            val(row,column)=layout.getIndexFromPosition(x,y,frameSize!!)
            model.onClick(row,column)
        }
    }

    override fun draw(canvas: Canvas?) {
        layout.place(model.getArray(), frameSize!!)
        val listSel = if (isFinished) layersFalse else layersSelected
        model.getArray().forEach {
            it.forEach { dataItem ->
                val list = if (dataItem.selected) listSel else layers
                list.forEach { drawer ->
                    drawer.draw(canvas, dataItem)
                }
            }
        }
    }

    override fun check() {
        val res= model.check()
        res.forEachIndexed{index, isCorrect ->
            model.select(index,1,!isCorrect)
        }
        isFinished =true
        updateView()
    }


}