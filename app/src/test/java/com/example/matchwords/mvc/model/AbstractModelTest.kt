package com.example.matchwords.mvc.model

import com.example.matchwords.mvc.model.source.SampleSource
import com.example.matchwords.mvc.model.source.SlicedSource
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class AbstractModelTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getItemList() {

    }

    @Test
    fun select() {
        val model= SimpleSelectionModel(SlicedSource(SampleSource(),0,3))
        assertEquals(model.getItem(2,0).selected, false)
        model.select(2,0,true)
        assertEquals(model.getItem(2,0).selected, true)
        assertEquals(othersNotSelected(model,2,0),true)

    }


    @Test
    fun getArray() {
        val model= SimpleSelectionModel(SlicedSource(SampleSource(),0,3))
        assertEquals(model.getRowCount(), 4)
        assertEquals(model.getItem(0,0).text , "1")
        assertEquals(model.getItem(0,1).text, "one")
        assertEquals(model.getItem(1,0).correctText,"2")
        assertEquals(model.getItem(1,1).correctText,"two")

        assertEquals(model.getItem(2,0).selected, false)
        assertEquals(model.getItem(2,1).selected, false)
        assertEquals(model.getItem(2,0).processed, false)
        assertEquals(model.getItem(2,1).processed, false)
        assertNull(model.getItem(2,0).rect)
        assertNull(model.getItem(2,1).rect)
    }

    @Test
    fun shuffle() {
        val model= SimpleSelectionModel(SampleSource())
        assertEquals(allCorrect(model),true)
        model.shuffle()
        val firstShuffle= allCorrect(model)
        model.shuffle()
        val secondShuffle=allCorrect(model)
        assertEquals(firstShuffle && secondShuffle,false)
    }

    private fun allCorrect(model: IModel):Boolean{
        for(it in 0 until model.getRowCount()){
            with(model.getItem(it,1)){
                if(text!= correctText) return false
            }
        }
        return true
    }
companion object{
    fun othersNotSelected(model: IModel, selRow: Int, selColumn: Int): Boolean{
        (0..3).forEach{
            if(it!=selRow && model.getItem(it,selColumn).selected) return false
        }
        return true
    }
}

}