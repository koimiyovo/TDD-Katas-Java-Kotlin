package com.salestaxesprolem.basketmanagement

import com.salestaxesprolem.utils.Format.withTwoDecimalPoint

class BasketItem(private val product: Product, private val quantity: Int) {

    fun resumeLine(): String = "$quantity ${product.name}: ${getPriceIncludingTaxes().withTwoDecimalPoint()}"

    fun getPriceIncludingTaxes() = product.getPriceIncludingTaxes() * quantity

    fun getTaxes() = product.getTaxes() * quantity
}
