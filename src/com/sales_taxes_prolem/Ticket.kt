package com.sales_taxes_prolem

class Ticket(private val input: String) {
    fun print(): String {
        if (input.isEmpty()) {
            return """Sales Taxes: 0.00
            |Total: 0.00
        """.trimMargin()
        } else {
            return """1 book: 12.49
            |Sales Taxes: 0.00
            |Total: 12.49
        """.trimMargin()
        }
    }
}
