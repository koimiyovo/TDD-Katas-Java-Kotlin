package com.sales_taxes_prolem

import com.sales_taxes_prolem.Round.withFormat2DecimalPoint

class OrderItem(private val product: Product, private val quantity: Int) {

    fun totalTTC() = product.productPriceTTC() * quantity

    fun tax() = product.productTax() * quantity

    fun resumeLine(): String = "$quantity ${product.name}: ${totalTTC().withFormat2DecimalPoint()}"
}
