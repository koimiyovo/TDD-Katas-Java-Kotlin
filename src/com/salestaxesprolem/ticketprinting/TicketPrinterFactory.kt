package com.salestaxesprolem.ticketprinting

import com.salestaxesprolem.basketmanagement.Basket

object TicketPrinterFactory {
    fun create(basket: Basket): StringPrinterStrategy {
        return when {
            basket.summary().isEmpty() -> {
                EmptyTicketPrinterStrategy()
            }
            else -> {
                TextTicketPrinterStrategy(basket)
            }
        }
    }
}
