package com.sales_taxes_prolem

import kotlin.math.roundToInt

object Round {
    fun Float.withFormat2DecimalPoint() = "%.2f".format(this).replace(',', '.')

    fun roundToNearest005(value: Float) = (value * 20).roundToInt() / 20.0F
}