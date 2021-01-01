package com.sales_taxes_prolem.ticket_printing

class EmptyTicket : Ticket() {

    override fun orderSummary() = ""

    override fun totalTaxes() = 0F

    override fun totalTTC() = 0F
}