package com.salestaxesprolem.utils

object Formatter
{
    fun Float.withTwoDecimalPoint() = "%.2f".format(this).replace(',', '.')
}