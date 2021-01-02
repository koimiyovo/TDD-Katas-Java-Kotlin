package com.sales_taxes_prolem.tax_management

class Order(private val orderItems: List<OrderItem>) {

    fun totalPriceIncludingTaxes() = orderItems.map { item -> item.priceIncludingTaxes() }.sum()

    fun totalTaxes() = orderItems.map { item -> item.taxes() }.sum()

    fun summary(): String {
        val output = StringBuilder()
        orderItems.forEach { item -> output.appendLine(item.resumeLine()) }
        return output.trimEnd().toString()
    }
}
