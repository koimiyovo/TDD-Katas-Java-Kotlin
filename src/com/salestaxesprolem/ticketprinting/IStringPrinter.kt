package com.salestaxesprolem.ticketprinting

interface IStringPrinter {
    val ticket: Ticket

    fun print(): String
}