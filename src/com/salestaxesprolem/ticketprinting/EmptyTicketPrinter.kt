package com.salestaxesprolem.ticketprinting

import com.salestaxesprolem.utils.Format.withTwoDecimalPoint

class EmptyTicketPrinter(override val ticket: EmptyTicket) : IStringPrinter {
    override fun print(): String = """Sales Taxes: ${ticket.totalTaxes.withTwoDecimalPoint()}
                                |Total: ${ticket.totalAmountIncludingTaxes.withTwoDecimalPoint()}
                            """.trimMargin()
}