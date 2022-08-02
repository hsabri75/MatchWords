package com.example.matchwords.mvc.model.source

class SampleSource: ISource {
    override fun getSourceData(): Array<Array<String>> {
        return arrayOf(
            arrayOf("one", "1"),
            arrayOf("two", "2"),
            arrayOf("three", "3"),
            arrayOf("four", "4"),
            arrayOf("five", "5"),
            arrayOf("six", "6"),
            arrayOf("seven", "7"),
            arrayOf("eight", "8"),
            arrayOf("nine", "9"),
            arrayOf("ten", "10"),
        )
    }
}