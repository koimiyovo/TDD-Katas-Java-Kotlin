package com.salestaxesprolem.taxmanagement

import com.salestaxesprolem.utils.Format.withTwoDecimalPoint

class OrderItem(private val product: Product, private val quantity: Int) {

    fun priceIncludingTaxes() = product.priceIncludingTaxes() * quantity

    fun taxes() = product.taxes() * quantity

    fun resumeLine(): String = "$quantity ${product.name}: ${priceIncludingTaxes().withTwoDecimalPoint()}"
}
