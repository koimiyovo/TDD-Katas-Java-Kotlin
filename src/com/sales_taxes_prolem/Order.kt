package com.sales_taxes_prolem

class Order(private val orderItems: List<OrderItem>) {

    fun totalOrderTTC() = orderItems.map { item -> item.totalTTC() }.sum()

    fun totalOrderTaxes() = orderItems.map { item -> item.tax() }.sum()

    fun orderSummary(): String {
        val output = StringBuilder()
        orderItems.forEach { item -> output.appendLine(item.resumeLine()) }
        return output.trimEnd().toString()
    }
}
