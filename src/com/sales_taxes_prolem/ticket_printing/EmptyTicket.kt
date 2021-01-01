package com.sales_taxes_prolem.ticket_printing

class EmptyTicket : Ticket() {

    private val ticketPrinter = EmptyTicketPrinter(this)

    override fun print() = ticketPrinter.print()

    override fun orderSummary() = ""

    override fun totalTaxes() = 0F

    override fun totalTTC() = 0F
}