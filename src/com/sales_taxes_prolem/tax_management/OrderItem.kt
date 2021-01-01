package com.sales_taxes_prolem.tax_management

import com.sales_taxes_prolem.utils.Format.withTwoDecimalPoint

class OrderItem(private val product: Product, private val quantity: Int) {

    fun totalTTC() = product.productPriceTTC() * quantity

    fun tax() = product.productTax() * quantity

    fun resumeLine(): String = "$quantity ${product.name}: ${totalTTC().withTwoDecimalPoint()}"
}
