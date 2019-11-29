package com.test.lolinformation.utils

import java.text.NumberFormat
import java.util.*

fun Int.formatNumb() = NumberFormat.getInstance(Locale.US).format(this).toString()
