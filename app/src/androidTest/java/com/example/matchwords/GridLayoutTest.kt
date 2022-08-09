package com.example.matchwords

import android.util.Size
import com.example.matchwords.mvc.controller.layout.GridLayout
import com.example.matchwords.mvc.model.IModel
import com.example.matchwords.mvc.model.SimpleSelectionModel
import com.example.matchwords.mvc.model.source.SampleSource
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test


class GridLayoutTest {
    private val sizeWidth=100
    private val sizeHeight=50
    private val fillRatio= GridLayout.fillRatio

    private lateinit var size: Size
    private lateinit var model: IModel

    @Before
    fun setUp() {
        size= Size(sizeWidth,sizeHeight)
        model= SimpleSelectionModel(SampleSource())
    }


    @Test
    fun place() {
        val gridLayout= GridLayout()

        with(model){

            assertThat(getItem(0,0).rect).isNull()
            gridLayout.place(this, size)
            assertThat(getItem(0,0).rect?.width()).isEqualTo(sizeWidth* fillRatio)
            assertThat(getItem(0,0).rect?.height()).isEqualTo(sizeHeight* fillRatio)
            assertThat(getItem(0,0).rect?.centerX()).isEqualTo(sizeWidth * 0.5F)
            assertThat(getItem(0,0).rect?.centerY()).isEqualTo(sizeHeight * 0.5F)

            assertThat(getItem(0,1).rect?.centerX()).isEqualTo(sizeWidth * 1.5F)
            assertThat(getItem(0,1).rect?.centerY()).isEqualTo(sizeHeight * 0.5F)
            assertThat(getItem(1,0).rect?.centerX()).isEqualTo(sizeWidth * 0.5F)
            assertThat(getItem(1,0).rect?.centerY()).isEqualTo(sizeHeight * 1.5F)

        }

    }

    @Test
    fun getIndexFromPosition() {
        val gridLayout= GridLayout()
        val(row,column) =gridLayout.getIndexFromPosition(sizeWidth-1F,sizeHeight-1F,size)
        assertThat(row).isEqualTo(0)
        assertThat(column).isEqualTo(0)
        val(row1,column1) =gridLayout.getIndexFromPosition(sizeWidth+1F,sizeHeight+1F,size)
        assertThat(row1).isEqualTo(1)
        assertThat(column1).isEqualTo(1)

    }
}