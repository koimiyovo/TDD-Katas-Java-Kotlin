package com.sales_taxes_prolem.ticket_printing

import com.sales_taxes_prolem.tax_management.Order

class TextTicket(order: Order) :
    Ticket(order.summary(), order.totalTaxes(), order.totalPriceIncludingTaxes())