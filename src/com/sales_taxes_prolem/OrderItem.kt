package com.sales_taxes_prolem

class OrderItem(private val product: Product, private val quantity: Int) {

    fun totalTTC() = product.priceTTC() * quantity;

    fun tax() = product.basicTax()

    fun resume(): String = "$quantity ${product.name}: ${Round.roundTo2DecimalPoint(totalTTC())}"
}
