package com.salestaxesprolem.basketmanagement

class Basket(private val basketItems: List<BasketItem>) {

    fun getTotalPriceIncludingTaxes() = basketItems.map { item -> item.getPriceIncludingTaxes() }.sum()

    fun getTotalTaxes() = basketItems.map { item -> item.getTaxes() }.sum()

    fun summary(): String {
        val output = StringBuilder()
        basketItems.forEach { item -> output.appendLine(item.resumeLine()) }
        return output.trimEnd().toString()
    }
}
