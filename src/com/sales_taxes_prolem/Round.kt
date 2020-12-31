package com.sales_taxes_prolem

import kotlin.math.roundToInt

object Round {
    fun withFormat2DecimalPoint(value: Float) = "%.2f".format(value).replace(',', '.')

    fun roundToNearest005(value: Float) = (value * 20).roundToInt() / 20.0F
}