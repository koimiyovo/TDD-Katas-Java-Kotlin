package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.ticketprinting.StringPrinterFactory

class WhenPrintTicket
{
    init
    {
        val ticketPrinterStrategy = StringPrinterFactory.create(basket)
        ticket = ticketPrinterStrategy.print()
    }
}