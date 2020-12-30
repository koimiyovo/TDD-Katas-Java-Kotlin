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
}