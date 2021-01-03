package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.utils.Format.withTwoDecimalPoint

class TextTicketPrinter(override val ticket: TextTicket) : IStringPrinter {
    override fun print(): String {
        val output = StringBuilder()
        output.appendLine(ticket.orderSummary)
        output.appendLine("Sales Taxes: ${ticket.totalTaxes.withTwoDecimalPoint()}")
        output.appendLine("Total: ${ticket.totalAmountIncludingTaxes.withTwoDecimalPoint()}")
        return output.trimEnd().toString()
    }
}