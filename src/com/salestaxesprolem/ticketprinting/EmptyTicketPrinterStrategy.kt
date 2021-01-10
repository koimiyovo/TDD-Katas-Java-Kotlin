package com.salestaxesprolem.ticketprinting

class EmptyTicketPrinterStrategy : StringPrinterStrategy {
    override fun print() = """Sales Taxes: 0.00
                                |Total: 0.00
                            """.trimMargin()

}