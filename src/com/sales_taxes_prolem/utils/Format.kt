package com.sales_taxes_prolem.utils

object Format {
    fun Float.withTwoDecimalPoint() = "%.2f".format(this).replace(',', '.')
}