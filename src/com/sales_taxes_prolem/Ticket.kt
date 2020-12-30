package com.sales_taxes_prolem

open class Ticket(private val order: Order?) {
    open fun print(): String {
        val output = StringBuilder()
        output.appendLine(order?.orderSummary())
        output.appendLine("Sales Taxes: ${Round.roundTo2DecimalPoint(order?.totalTaxes())}")
        output.appendLine("Total: ${Round.roundTo2DecimalPoint(order?.totalOrderTTC())}")
        return output.trimEnd().toString()
    }
}

class EmptyTicket : Ticket(null) {
    override fun print(): String {
        return """Sales Taxes: 0.00
            |Total: 0.00
        """.trimMargin()
    }
}
