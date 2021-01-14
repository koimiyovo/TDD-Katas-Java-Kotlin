package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.basketmanagement.Basket
import kotlin.test.assertEquals

object Then
{
    fun ticketIs(expectedTicket: String)
    {
        assertEquals(expectedTicket.trimMargin(), ticket)
        basket = Basket(emptyList())
    }
}