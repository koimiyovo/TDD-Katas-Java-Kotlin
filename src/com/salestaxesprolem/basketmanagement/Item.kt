package com.salestaxesprolem.basketmanagement

import com.salestaxesprolem.utils.Formatter.withTwoDecimalPoint

class Item(private val product: Product, private val quantity: Int)
{
    fun resumeLine(): String = "$quantity ${product.name}: ${priceIncludingTaxes().withTwoDecimalPoint()}"

    fun priceIncludingTaxes() = product.priceIncludingTaxes() * quantity

    fun taxes() = product.taxes() * quantity
}
