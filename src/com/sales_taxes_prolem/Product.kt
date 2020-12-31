package com.sales_taxes_prolem

class Product(val name: String, private val price: Float, val taxType: TaxType, val importType: ImportType) {
    fun priceTTC() = price + totalTax()

    fun totalTax() = basicTax() + importTax()

    private fun basicTax() = price * taxType.percentage

    private fun importTax() = price * importType.percentage
}
