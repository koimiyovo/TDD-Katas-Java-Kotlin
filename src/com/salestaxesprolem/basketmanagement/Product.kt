package com.salestaxesprolem.basketmanagement

import com.salestaxesprolem.taxmanagement.ImportType
import com.salestaxesprolem.taxmanagement.TaxType
import com.salestaxesprolem.utils.Rounder.roundToNearest005

class Product(
    val name: String,
    private val price: Float,
    private val taxType: TaxType,
    private val importType: ImportType)
{
    fun priceIncludingTaxes() = price + taxes()

    fun taxes() = basicTax() + importTax()

    private fun basicTax() = (price * taxType.value).roundToNearest005()

    private fun importTax() = (price * importType.value).roundToNearest005()
}
