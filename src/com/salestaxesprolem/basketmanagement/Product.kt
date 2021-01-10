package com.salestaxesprolem.basketmanagement

import com.salestaxesprolem.taxmanagement.importtype.ImportType
import com.salestaxesprolem.taxmanagement.importtype.ImportTypeFactory
import com.salestaxesprolem.taxmanagement.taxtype.TaxType
import com.salestaxesprolem.taxmanagement.taxtype.TaxTypeFactory
import com.salestaxesprolem.utils.Round

class Product(
    val name: String,
    private val price: Float,
    private val taxType: TaxType,
    private val importType: ImportType
) {
    fun getPriceIncludingTaxes() = price + getTaxes()

    fun getTaxes() = getBasicTax() + getImportTax()

    private fun getBasicTax() = Round.roundToNearest005(price * getTaxTypePercentage())

    private fun getTaxTypePercentage() = TaxTypeFactory.create(taxType).percentage()

    private fun getImportTax() = Round.roundToNearest005(price * getImportTypePercentage())

    private fun getImportTypePercentage() = ImportTypeFactory.create(importType).percentage()
}
