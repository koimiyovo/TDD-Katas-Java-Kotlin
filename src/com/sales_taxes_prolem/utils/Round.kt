package com.sales_taxes_prolem.utils

import kotlin.math.roundToInt

object Round {
    fun roundToNearest005(value: Float) = (value * 20).roundToInt() / 20.0F
}