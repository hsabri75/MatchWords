package com.example.matchwords.mvc.utilities

import android.graphics.RectF

data class MutableDataItem(var text: String, var rect: RectF?= null, var selected: Boolean=false, var processed: Boolean=false, var correctText: String?=null) {

}