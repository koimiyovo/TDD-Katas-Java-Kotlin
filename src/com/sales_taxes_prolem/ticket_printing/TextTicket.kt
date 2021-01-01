package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.tax_management.Order

class TextTicket(private val order: Order) : Ticket() {
    
    init {
        ticketOrder = this.order
    }

    override fun orderSummary(): String = ticketOrder.orderSummary()

    override fun totalTaxes(): Float = ticketOrder.totalOrderTaxes()

    override fun totalTTC(): Float = ticketOrder.totalOrderTTC()
}