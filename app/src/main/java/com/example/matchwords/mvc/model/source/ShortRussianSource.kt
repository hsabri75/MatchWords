package com.example.matchwords.mvc.model.source

class ShortRussianSource : ISource{

    override fun getSourceData(): Array<Array<String>> {
        return arrayOf(
            arrayOf("кормовОй", "kıç"),
            arrayOf("гранАта", "bomba"),
            arrayOf("скОс", "köşe pahı"),
            arrayOf("куполообразный", "kubbe şeklinde"),
            arrayOf("фАра", "far"),
            arrayOf("щитОк", "kalkan"),
            arrayOf("лЮк", "manhole"),
            arrayOf("сверлИть", "delmek"),
            arrayOf("сцеплЕние", "debriyaj"),
            arrayOf("стрельбА", "atış"),
            arrayOf("пУшка", "gun, cannon"),
            arrayOf("бронирование", "zırh"),
            arrayOf("бУфер", "tampon"),
            arrayOf("тормознОй", "fren"),
        )
    }
}