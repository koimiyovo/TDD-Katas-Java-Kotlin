package com.sales_taxes_prolem

object Round {
    fun roundTo2DecimalPoint(value: Float?) = "%.2f".format(value).replace(',', '.')
}