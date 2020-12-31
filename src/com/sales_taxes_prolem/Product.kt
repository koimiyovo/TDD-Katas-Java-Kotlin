package com.sales_taxes_prolem

class Product(val name: String, private val price: Float, val taxType: TaxType, val importType: ImportType) {

    fun productPriceTTC() = price + productTax()

    fun productTax() = basicTax() + importTax()

    private fun basicTax() = Round.roundToNearest005(price * taxType.percentage)

    private fun importTax() = Round.roundToNearest005(price * importType.percentage)
}
