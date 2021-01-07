package com.salestaxesprolem.ticketprinting

import com.salestaxesprolem.taxmanagement.Order

class TextTicket(order: Order) :
    Ticket(order.summary(), order.totalTaxes(), order.totalPriceIncludingTaxes())