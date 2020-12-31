package com.sales_taxes_prolem

import com.sales_taxes_prolem.Round.withFormat2DecimalPoint

open class Ticket(private val order: Order?) {
    open fun print(): String {
        val output = StringBuilder()
        output.appendLine(order?.orderSummary())
        output.appendLine("Sales Taxes: ${order?.totalOrderTaxes()?.withFormat2DecimalPoint()}")
        output.appendLine("Total: ${order?.totalOrderTTC()?.withFormat2DecimalPoint()}")
        return output.trimEnd().toString()
    }
}

class EmptyTicket : Ticket(null) {
    override fun print() = """Sales Taxes: 0.00
                                |Total: 0.00
                            """.trimMargin()
}
