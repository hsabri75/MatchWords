package com.example.matchwords.mvc.controller

import android.graphics.Canvas
import android.util.Size
import com.example.matchwords.mvc.controller.layout.ILayout
import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.view.IView
import com.example.matchwords.mvc.view.modeldrawer.IModelDrawer
import com.example.matchwords.mvc.view.modeldrawer.ModelDrawer


class Controller (private val view: IView
                  , private val model: IModel
                  , private val layout: ILayout
                  , private val drawerGroup: IModelDrawer
): IController {
    private var frameSize: Size? =null
    private var isFinished=false

    init{
        view.setController(this)
        model.setController(this)
        model.shuffle()
        updateView()
    }
    override fun updateView(){
        if(frameSize==null){
            frameSize=Size(view.getViewSize().width / model.getColumnCount(),
                view.getViewSize().height / model.getRowCount())
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
        layout.place(model, frameSize!!)
        drawerGroup.draw(canvas, model, isFinished)
    }

    override fun check():Int {
        var count=0
        (0 until model.getRowCount()).forEach {
            with(model.getItem(it,1)){
                if(text== correctText) count++
            }
        }
        isFinished =true
        updateView()
        return count
    }


}