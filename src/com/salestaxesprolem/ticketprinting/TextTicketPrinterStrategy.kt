package com.salestaxesprolem.ticketprinting

import com.salestaxesprolem.basketmanagement.Basket
import com.salestaxesprolem.utils.Formatter.withTwoDecimalPoint

class TextTicketPrinterStrategy(private val basket: Basket) : StringPrinterStrategy
{
    override fun print(): String
    {
        val output = StringBuilder()
        output.appendLine(basket.summary())
        output.appendLine("Sales Taxes: ${basket.totalTaxes().withTwoDecimalPoint()}")
        output.append("Total: ${basket.totalPriceIncludingTaxes().withTwoDecimalPoint()}")
        return output.toString()
    }

}
