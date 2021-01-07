package com.salestaxesprolem.taxmanagement

import com.salestaxesprolem.utils.Round

class Product(
    val name: String,
    private val price: Float,
    private val taxType: TaxType,
    private val importType: ImportType
) {
    fun priceIncludingTaxes() = price + taxes()

    fun taxes() = basicTax() + importTax()

    private fun basicTax() = Round.roundToNearest005(price * taxType.percentage)

    private fun importTax() = Round.roundToNearest005(price * importType.percentage)
}
