package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.ticketprinting.StringPrinterFactory

var ticket = ""

class WhenPrintTicket
{
    init
    {
        val ticketPrinterStrategy = StringPrinterFactory.create(basket)
        ticket = ticketPrinterStrategy.print()
    }
}