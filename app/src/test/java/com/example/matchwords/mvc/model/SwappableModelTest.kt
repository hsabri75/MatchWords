package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.model.source.SampleSource
import com.example.matchwords.mvc.model.source.SlicedSource
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class SwappableModelTest {

    private lateinit var model: SwappableModel

    @Before
    fun setUp() {
        model= SwappableModel(SlicedSource(SampleSource(),0,3))
    }


    @Test
    fun test_SelectedAfterFirstOnclickFirstColumn(){
        model.onClick(3,0)
        assertEquals(model.getItem(3,0).selected, true)
    }

    @Test
    fun test_SelectedAfterSecondOnclickFirstColumn(){
        model.onClick(3,0)
        model.onClick(2,0)
        assertEquals(model.getItem(2,0).selected, true)
        assertEquals(model.getItem(3,0).selected, false)
    }

    @Test
    fun test_ProcessedAfterSelectBothColumns(){
        model.onClick(0,0)
        model.onClick(1,1)
        assertEquals(model.getItem(0,0).processed, true)
        assertEquals(model.getItem(0,1).processed, true)
    }

    @Test
    fun test_SwapAfterSelectBothColumns(){
        model.onClick(0,0)
        model.onClick(1,1)
        assertEquals(model.getItem(0,0).text, "1")
        assertEquals(model.getItem(0,1).text, "two")
    }

}