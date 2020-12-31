package com.sales_taxes_prolem

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SaleTest {
    private val book = Product("book", 12.49F, taxType = NoTax())
    private val chocolateBar = Product("chocolate bar", 0.85F, taxType = NoTax())
    private val musicCD = Product("music CD", 14.99F, taxType = BasicTax())

    private val importedBoxOfChocolates =
        Product("imported box of chocolates", 10F, taxType = NoTax(), importType = Imported())

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

    @Test
    fun `given 1 music CD at 14_99 then the basic tax is applied`() {
        // Given
        val orderItems = mutableListOf<OrderItem>()
        orderItems.add(OrderItem(musicCD, 1))

        val input = Order(orderItems)
        val ticketExpected = """1 music CD: 16.49
            |Sales Taxes: 1.50
            |Total: 16.49
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 2 music CD at 14_99 then the basic tax is applied`() {
        // Given
        val orderItems = mutableListOf<OrderItem>()
        orderItems.add(OrderItem(musicCD, 2))

        val input = Order(orderItems)
        val ticketExpected = """2 music CD: 32.98
            |Sales Taxes: 3.00
            |Total: 32.98
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `test with 2 books and 1 music CD and 1 chocolate bar`() {
        // Given
        val orderItems = mutableListOf<OrderItem>()
        orderItems.add(OrderItem(book, 2))
        orderItems.add(OrderItem(musicCD, 1))
        orderItems.add(OrderItem(chocolateBar, 1))

        val input = Order(orderItems)
        val ticketExpected = """2 book: 24.98
            |1 music CD: 16.49
            |1 chocolate bar: 0.85
            |Sales Taxes: 1.50
            |Total: 42.32
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given one imported product then import tax is applied`() {
        // Given
        val orderItems = mutableListOf<OrderItem>()
        orderItems.add(OrderItem(importedBoxOfChocolates, 1))

        val input = Order(orderItems)
        val ticketExpected = """1 imported box of chocolates: 10.50
            |Sales Taxes: 0.50
            |Total: 10.50
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }
}