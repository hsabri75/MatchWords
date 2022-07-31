package com.example.matchwords.mvc.controller

import android.graphics.RectF
import android.util.Size
import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.view.IView
import com.example.matchwords.mvc.view.framedtext.FramedPainter
import com.example.matchwords.mvc.view.framedtext.FramedText


class FramedTextController (private val view: IView
                        , private val model: IModel
                        , private val selPainter:FramedPainter): IController {
    private val fillRatio = 0.8F
    private lateinit var frameSize: Size
    init{
        view.setController(this)
        model.setController(this)
    }
    override fun updateView(){
        view.updateView(getFrameList())
    }

    override fun onClick(x: Float, y: Float) {
        val(row,column)=getIdFromPosition(x,y)
        model.select(row,column)
    }

    private fun getIdFromPosition(x: Float, y: Float): Pair<Int, Int>{
        val row = (y/frameSize.height).toInt()
        val column= (x/frameSize.width).toInt()
        return Pair(row,column)
    }

    private fun getFrameList(): List<FramedText>{
        val list= mutableListOf<FramedText>()
        val viewSize = view.getViewSize()
            val textData = model.getData()
            val isProcessed = model.isProcessed()
            frameSize = getSingleFrameSize(viewSize,textData.size, textData[0].size)
            val calcWidth = frameSize.width * fillRatio
            val calcHeight = frameSize.height * fillRatio
            textData.forEachIndexed{ row, array ->
                array.forEachIndexed{ column, string ->
                    val processEffect= if(isProcessed[row]) 1 else 0
                    val sign = (if (column==0) 1 else -1)
                    val x0 = (column    + 0.5F - fillRatio/2) * frameSize.width + sign * processEffect * (frameSize.width * (1-fillRatio) )/2
                    val y0 = (row       + 0.5F - fillRatio/2) * frameSize.height
                    val(selRow, selColumn)= model.getSelection()

                    val framedText=if(row== selRow && column == selColumn){
                        FramedText(string, RectF( x0, y0, x0+ calcWidth, y0+calcHeight ), selPainter)

                    }else{
                        FramedText(string, RectF( x0, y0, x0+ calcWidth, y0+calcHeight ))

                    }



                    list.add(framedText)
                }
            }

        return list
    }

    private fun getSingleFrameSize(viewSize: Size, rowCount: Int, columnCount: Int) : Size{
            return Size(viewSize.width/columnCount, viewSize.height/rowCount )
    }




}