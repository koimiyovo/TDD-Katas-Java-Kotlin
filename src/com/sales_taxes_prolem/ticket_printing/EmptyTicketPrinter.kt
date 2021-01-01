package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.utils.Format.withTwoDecimalPoint

class EmptyTicketPrinter(ticket: Ticket) : TicketPrinter(ticket) {
    fun print(): String = """Sales Taxes: ${ticket.totalTaxes().withTwoDecimalPoint()}
                                |Total: ${ticket.totalTTC().withTwoDecimalPoint()}
                            """.trimMargin()
}