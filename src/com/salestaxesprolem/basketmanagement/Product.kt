package com.salestaxesprolem.basketmanagement

import com.salestaxesprolem.taxmanagement.ImportType
import com.salestaxesprolem.taxmanagement.TaxType
import com.salestaxesprolem.utils.Round

class Product(
    val name: String,
    private val price: Float,
    private val taxType: TaxType,
    private val importType: ImportType
) {
    fun getPriceIncludingTaxes() = price + getTaxes()

    fun getTaxes() = getBasicTax() + getImportTax()

    private fun getBasicTax() = Round.roundToNearest005(price * taxType.value)

    private fun getImportTax() = Round.roundToNearest005(price * importType.value)
}
