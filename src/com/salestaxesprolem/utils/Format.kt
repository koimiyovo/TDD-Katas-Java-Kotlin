package com.salestaxesprolem.utils

object Format {
    fun Float.withTwoDecimalPoint() = "%.2f".format(this).replace(',', '.')
}