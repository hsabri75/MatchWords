package com.example.matchwords.mvc.controller

import android.graphics.Canvas
import android.util.Size
import com.example.matchwords.mvc.controller.layout.ILayout
import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.view.IView
import com.example.matchwords.mvc.view.modeldrawer.ModelDrawer


class Controller (private val view: IView
                  , private val model: IModel
                  , private val layout: ILayout
                  , private val drawerGroup: ModelDrawer
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
        drawerGroup.draw(canvas, model, isFinished)
    }

    override fun check() {
        model.getArray().forEachIndexed{ index, arrElement ->
            model.select(index,0,false)
            val isCorrect = arrElement[1].correctText != arrElement[1].text
            model.select(index,1, isCorrect)
        }
        isFinished =true
        updateView()
    }


}