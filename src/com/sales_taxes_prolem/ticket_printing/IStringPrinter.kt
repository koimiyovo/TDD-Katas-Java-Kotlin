package com.sales_taxes_prolem.ticket_printing

interface IStringPrinter {
    val ticket: Ticket

    fun print(): String
}