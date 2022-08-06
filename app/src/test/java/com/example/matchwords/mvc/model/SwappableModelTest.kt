package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.model.source.SampleSource
import com.example.matchwords.mvc.model.source.SlicedSource
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class SwappableModelTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun onClick_first_column(){
        val model= SwappableModel(SlicedSource(SampleSource(),0,3))
        assertEquals(model.getItem(3,0).selected, false)
        assertEquals(model.getItem(3,0).processed, false)
        model.onClick(3,0)
        assertEquals(model.getItem(3,0).selected, true)
        assertEquals(AbstractModelTest.othersNotSelected(model,3,0),true)
        model.onClick(2,0)
        assertEquals(model.getItem(2,0).selected, true)
        assertEquals(AbstractModelTest.othersNotSelected(model,2,0),true)
    }

    @Test
    fun onClick_secondRow(){
        val model= SwappableModel(SlicedSource(SampleSource(),0,3))
        assertEquals(model.getItem(3,1).selected, false)
        assertEquals(model.getItem(3,1).processed, false)
        model.onClick(3,1)
        assertEquals(model.getItem(3,1).selected, true)
        assertEquals(AbstractModelTest.othersNotSelected(model,3,1),true)
        model.onClick(2,1)
        assertEquals(model.getItem(2,1).selected, true)
        assertEquals(AbstractModelTest.othersNotSelected(model,2,1),true)
    }

    @Test
    fun onClick() {
        val model = SwappableModel(SlicedSource(SampleSource(), 0, 3))
        model.onClick(0,0)
        model.onClick(1,1)
        assertEquals(model.getItem(0,0).text, "1")
        assertEquals(model.getItem(0,1).text, "two")
        assertEquals(model.getItem(0,0).processed, true)
        assertEquals(model.getItem(0,1).processed, true)

        assertEquals(model.getItem(1,0).text, "2")
        assertEquals(model.getItem(1,1).text, "one")
        assertEquals(model.getItem(1,0).processed, false)
        assertEquals(model.getItem(1,1).processed, false)
    }


    @Test
    fun swap() {
        val model = SwappableModel(SlicedSource(SampleSource(), 0, 3))
        model.swap(0,1)
        assertEquals(model.getItem(0,0).text , "1")
        assertEquals(model.getItem(0,1).text , "two")
        assertEquals(model.getItem(0,1).correctText , "one")
        assertEquals(model.getItem(0,0).processed, true)
        assertEquals(model.getItem(0,1).processed, true)

        assertEquals(model.getItem(1,0).text , "2")
        assertEquals(model.getItem(1,1).text , "one")
        assertEquals(model.getItem(0,1).correctText , "one")
        assertEquals(model.getItem(1,0).processed, false)
        assertEquals(model.getItem(1,1).processed, false)

        model.swap(2,0)
        assertEquals(model.getItem(0,0).text , "1")
        assertEquals(model.getItem(0,1).text , "three")
        assertEquals(model.getItem(0,1).correctText , "one")
        assertEquals(model.getItem(0,0).processed, true)
        assertEquals(model.getItem(0,1).processed, true)

        assertEquals(model.getItem(2,0).text , "3")
        assertEquals(model.getItem(2,1).text , "two")
        assertEquals(model.getItem(2,1).correctText , "three")
        assertEquals(model.getItem(2,0).processed, true)
        assertEquals(model.getItem(2,1).processed, true)
    }
}