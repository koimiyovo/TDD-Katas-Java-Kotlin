package com.salestaxesprolem.tests

import com.salestaxesprolem.basketmanagement.Basket
import com.salestaxesprolem.ticketprinting.StringPrinterFactory
import kotlin.test.assertEquals

class Given(private val basket: Basket)
{
    private var ticket: String = ""

    fun whenPrintTicket() = apply {
        val ticketPrinterStrategy = StringPrinterFactory.create(basket)
        ticket = ticketPrinterStrategy.print()
    }

    fun thenTicketIs(expectedTicket: String) = assertEquals(expectedTicket, ticket)
}
