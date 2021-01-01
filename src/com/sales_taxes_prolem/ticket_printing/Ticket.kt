package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.tax_management.Order

abstract class Ticket(private val order: Order? = null) {
    
    abstract fun orderSummary(): String

    abstract fun totalTaxes(): Float

    abstract fun totalTTC(): Float
}
