package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.basketmanagement.Basket
import kotlin.test.assertEquals

class ThenTicketIs(expectedTicket: String)
{
    init
    {
        assertEquals(expectedTicket.trimMargin(), ticket)
        basket = Basket(emptyList())
    }
}