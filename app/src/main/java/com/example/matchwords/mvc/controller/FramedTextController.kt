package com.example.matchwords.mvc.controller

import android.graphics.RectF
import android.util.Size
import com.example.matchwords.mvc.view.IView
import com.example.matchwords.mvc.view.framedtext.FramedText


class FramedTextController (private val view: IView, private val textData: Array<Array<String>>): IController {
    private val fillRatio = 0.95F
    init{
        view.setController(this)
    }
    override fun updateView(){
        view.updateView(getFrameList())
    }

    private fun getFrameList(): List<FramedText>{
        val list= mutableListOf<FramedText>()
        val singleFrame = getSingleFrameSize(view.getViewDimensionsHeight(),textData.size, textData[0].size)
        val calcWidth = singleFrame.width * fillRatio
        val calcHeight = singleFrame.height * fillRatio
        textData.forEachIndexed{ row, array ->
            array.forEachIndexed{ column, string ->
                val x0 = (column    + 0.5F - fillRatio/2) * singleFrame.width
                val y0 = (row       + 0.5F - fillRatio/2) * singleFrame.height
                val framedText= FramedText(string, RectF( x0, y0, x0+ calcWidth, y0+calcHeight ))
                list.add(framedText)
            }
        }
        return list
    }

    private fun getSingleFrameSize(viewSize: Size, rowCount: Int, columnCount: Int) : Size{
            return Size(viewSize.width/columnCount, viewSize.height/rowCount )
    }




}