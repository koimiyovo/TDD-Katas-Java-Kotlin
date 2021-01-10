package com.salestaxesprolem.ticketprinting

import com.salestaxesprolem.basketmanagement.Basket
import com.salestaxesprolem.utils.Format.withTwoDecimalPoint

class TextTicketPrinterStrategy(private val basket: Basket) : StringPrinterStrategy {
    override fun print(): String {
        val output = StringBuilder()
        output.appendLine(basket.summary())
        output.appendLine("Sales Taxes: ${basket.getTotalTaxes().withTwoDecimalPoint()}")
        output.append("Total: ${basket.getTotalPriceIncludingTaxes().withTwoDecimalPoint()}")
        return output.toString()
    }

}
