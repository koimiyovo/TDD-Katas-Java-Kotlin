package com.sales_taxes_prolem

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SaleTest {
    @Test
    fun `given empty input then ticket is empty`() {
        // Given
        val input = ""
        val ticketExpected = """Sales Taxes: 0.00
            |Total: 0.00
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 book at 12_49 then no tax is applied`() {
        // Given
        val input = "1 book at 12.49"
        val ticketExpected = """1 book: 12.49
            |Sales Taxes: 0.00
            |Total: 12.49
        """.trimMargin()

        // When
        val result = Ticket(input).print()

        // Then
        assertEquals(ticketExpected, result)
    }
}