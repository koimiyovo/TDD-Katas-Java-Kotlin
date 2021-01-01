package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.utils.Format.withTwoDecimalPoint

class EmptyTicketPrinter(override val ticket: EmptyTicket) : IStringPrinter {
    override fun print(): String = """Sales Taxes: ${ticket.totalTaxes.withTwoDecimalPoint()}
                                |Total: ${ticket.totalTTC.withTwoDecimalPoint()}
                            """.trimMargin()
}