package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.ticketprinting.StringPrinterFactory

var ticket = ""

object When
{
    fun printTicket()
    {
        val ticketPrinterStrategy = StringPrinterFactory.create(basket)
        ticket = ticketPrinterStrategy.print()
    }
}