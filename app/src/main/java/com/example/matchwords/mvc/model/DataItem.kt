package com.example.matchwords.mvc.model

import android.graphics.RectF

data class DataItem(var text: String, var rect: RectF? =null, var selected: Boolean=false, var processed: Boolean=false) {

}