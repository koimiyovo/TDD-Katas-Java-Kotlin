package com.salestaxesprolem.ticketprinting

import com.salestaxesprolem.basketmanagement.Basket

object StringPrinterFactory
{
    fun create(basket: Basket): StringPrinterStrategy
    {
        return when
        {
            basket.isEmpty() ->
            {
                EmptyTicketPrinterStrategy()
            }
            else ->
            {
                TextTicketPrinterStrategy(basket)
            }
        }
    }
}
