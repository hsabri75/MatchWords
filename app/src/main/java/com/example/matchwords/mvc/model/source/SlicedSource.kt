package com.example.matchwords.mvc.model.source

class SlicedSource(private val source: ISource, private val start: Int, private val end: Int): ISource {
    override fun getSourceData(): Array<Array<String>> {
        val arr= source.getSourceData()
        return arr.slice(start..end).toTypedArray()
    }

}