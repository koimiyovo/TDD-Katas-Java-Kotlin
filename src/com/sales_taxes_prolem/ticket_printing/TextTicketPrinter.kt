package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.utils.Format.withTwoDecimalPoint

class TextTicketPrinter(ticket: Ticket) : TicketPrinter(ticket) {
    fun print(): String {
        val output = StringBuilder()
        output.appendLine(ticket.orderSummary())
        output.appendLine("Sales Taxes: ${ticket.totalTaxes().withTwoDecimalPoint()}")
        output.appendLine("Total: ${ticket.totalTTC().withTwoDecimalPoint()}")
        return output.trimEnd().toString()
    }
}