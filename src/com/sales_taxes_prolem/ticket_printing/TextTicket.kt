package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.tax_management.Order

class TextTicket(private val order: Order) : Ticket(order) {

    override fun orderSummary(): String = order.orderSummary()

    override fun totalTaxes(): Float = order.totalOrderTaxes()

    override fun totalTTC(): Float = order.totalOrderTTC()
}