package com.sales_taxes_prolem

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SaleTest {
    private val book = Product("book", 12.49F)
    private val chocolateBar = Product("chocolate bar", 0.85F)

    @Test
    fun `given empty input then ticket is empty`() {
        // Given
        val ticketExpected = """Sales Taxes: 0.00
            |Total: 0.00
        """.trimMargin()

        // When
        val result = EmptyTicket().print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 book at 12_49 then no tax is applied`() {
        // Given
        val orderItems = mutableListOf<OrderItem>()
        orderItems.add(OrderItem(book, 1))

        val input = Order(orderItems)
        val ticketExpected = """1 book: 12.49
            |Sales Taxes: 0.00
            |Total: 12.49
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 chocolate bar at 0_85 then no tax is applied`() {
        // Given
        val orderItems = mutableListOf<OrderItem>()
        orderItems.add(OrderItem(chocolateBar, 1))

        val input = Order(orderItems)
        val ticketExpected = """1 chocolate bar: 0.85
            |Sales Taxes: 0.00
            |Total: 0.85
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 book at 12_49 and 1 chocolate bar at 0_85 then no tax is applied`() {
        // Given
        val orderItems = mutableListOf<OrderItem>()
        orderItems.add(OrderItem(book, 1))
        orderItems.add(OrderItem(chocolateBar, 1))

        val input = Order(orderItems)
        val ticketExpected = """1 book: 12.49
            |1 chocolate bar: 0.85
            |Sales Taxes: 0.00
            |Total: 13.34
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }
}