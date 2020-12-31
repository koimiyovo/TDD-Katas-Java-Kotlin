package com.sales_taxes_prolem

class Order(private val orderItems: List<OrderItem>) {
    fun totalOrderTTC(): Float = orderItems.map { item -> item.totalTTC() }.sum()

    fun totalOrderTaxes(): Float = orderItems.map { item -> item.tax() }.sum()

    fun orderSummary(): String {
        val output = StringBuilder()
        orderItems.forEach { item ->
            output.appendLine(item.resume())
        }
        return output.trimEnd().toString()
    }
}
