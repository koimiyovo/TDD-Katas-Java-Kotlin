package com.salestaxesprolem.taxmanagement

import com.salestaxesprolem.taxmanagement.taxtype.TaxType
import com.salestaxesprolem.taxmanagement.taxtype.TaxTypeFactory
import com.salestaxesprolem.utils.Round

class Product(
    val name: String,
    private val price: Float,
    private val taxType: TaxType,
    private val importType: ImportType
) {
    fun priceIncludingTaxes() = price + taxes()

    fun taxes() = basicTax() + importTax()

    private fun basicTax() = Round.roundToNearest005(price * taxPercentage())

    private fun importTax() = Round.roundToNearest005(price * importType.percentage)

    private fun taxPercentage() = TaxTypeFactory.create(taxType).percentage()
}
