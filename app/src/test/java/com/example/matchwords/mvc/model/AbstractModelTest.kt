package com.example.matchwords.mvc.model

import android.util.Log
import android.util.Size
import com.example.matchwords.mvc.model.source.SampleSource
import com.example.matchwords.mvc.model.source.SlicedSource
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AbstractModelTest {

    private lateinit var model: AbstractModel

    @Before
    fun setUp() {
        model= SimpleSelectionModel(SlicedSource(SampleSource(), 0, 3))
    }

    @Test
    fun test_ModelSize() {
        assertEquals(model.getRowCount(), 4)
    }

    @Test
    fun test_InitiallyNotSelected() {
        assertEquals(model.getItem(2, 0).selected, false)
    }

    @Test
    fun test_InitiallyNotProcessed() {
        assertEquals(model.getItem(2, 0).processed, false)
    }

    @Test
    fun test_InitialText() {
        assertEquals(model.getItem(0,0).text , "1")
    }

    @Test
    fun test_FirstColumnInitialCorrectTextNull() {
        model.shuffle()
        assertNull(model.getItem(0,0).correctText)
    }

    @Test
    fun test_SecondColumnInitialCorrectText() {
        model.shuffle()
        assertEquals(model.getItem(1,1).correctText,"two")
    }

    @Test
    fun test_SelectedAfterSelect() {
        model.select(2, 0, true)
        assertEquals(model.getItem(2, 0).selected, true)
    }

    @Test
    fun test_OtherColumnAfterSelect() {
        model.select(2, 0, true)
        assertEquals(model.getItem(2, 1).selected, false)
    }

    @Test
    fun test_OtherRowAfterSelect() {
        model.select(2, 0, true)
        assertEquals(model.getItem(3, 0).selected, false)
    }

    @Test
    fun test_ShuffleSuccessful() {
        model.shuffle()
        val firstShuffle= allCorrect(model)
        model.shuffle()
        val secondShuffle=allCorrect(model)
        assertEquals(firstShuffle && secondShuffle,false)
    }

    private fun allCorrect(model: IModel):Boolean{
        for(it in 0 until model.getRowCount()){
            with(model.getItem(it,1)){
                if(text != correctText) return false
            }
        }
        return true
    }

}