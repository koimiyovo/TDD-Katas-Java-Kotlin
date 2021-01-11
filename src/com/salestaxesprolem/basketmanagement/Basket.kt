package com.salestaxesprolem.basketmanagement

class Basket(private val items: List<Item>)
{
    fun totalPriceIncludingTaxes() = items.map { item -> item.priceIncludingTaxes() }.sum()

    fun totalTaxes() = items.map { item -> item.taxes() }.sum()

    fun isEmpty() = summary().isEmpty()

    fun summary(): String
    {
        val output = StringBuilder()
        items.forEach { item -> output.appendLine(item.resumeLine()) }
        return output.trimEnd().toString()
    }
}
