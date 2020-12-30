package com.sales_taxes_prolem

class Ticket(val input: String) {
    fun print(): String {
        return """Sales Taxes: 0.00
            |Total: 0.00
        """.trimMargin()
    }
}
