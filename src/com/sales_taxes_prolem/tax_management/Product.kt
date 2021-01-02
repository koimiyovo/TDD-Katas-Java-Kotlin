package com.sales_taxes_prolem.tax_management

import com.sales_taxes_prolem.utils.Round

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
