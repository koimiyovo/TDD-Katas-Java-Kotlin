package com.sales_taxes_prolem

class Product(val name: String, private val price: Float, val taxType: TaxType) {
    fun priceTTC() = price + basicTax()

    fun basicTax() = price * taxType.percentage
}
