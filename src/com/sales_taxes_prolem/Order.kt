package com.sales_taxes_prolem

class Order(private val orderItems: List<OrderItem>) {
    fun totalOrderTTC(): Float = orderItems.map { item -> item.totalTTC() }.sum()

    fun totalTaxes(): Float = 0.0F

    fun orderSummary(): String {
        val output = StringBuilder()
        orderItems.forEach { item ->
            output.appendLine(item.resume())
        }
        return output.trimEnd().toString()
    }
}
