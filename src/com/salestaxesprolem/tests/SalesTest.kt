package com.salestaxesprolem.tests

import com.salestaxesprolem.basketmanagement.Basket
import com.salestaxesprolem.tests.TestConstants.ONE_BOOK_NOT_IMPORTED
import com.salestaxesprolem.tests.TestConstants.ONE_BOTTLE_OF_PERFUME_NOT_IMPORTED
import com.salestaxesprolem.tests.TestConstants.ONE_CHOCOLATE_BAR_NOT_IMPORTED
import com.salestaxesprolem.tests.TestConstants.ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_27_99F
import com.salestaxesprolem.tests.TestConstants.ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_47_5F
import com.salestaxesprolem.tests.TestConstants.ONE_IMPORTED_BOX_OF_CHOCOLATES_AT_10F
import com.salestaxesprolem.tests.TestConstants.ONE_MUSIC_CD_NOT_IMPORTED
import com.salestaxesprolem.tests.TestConstants.ONE_PACKET_OF_HEADACHE_PILLS_NOT_IMPORTED
import com.salestaxesprolem.tests.TestConstants.THREE_IMPORTED_BOXES_OF_CHOCOLATES_AT_11_25F
import com.salestaxesprolem.tests.TestConstants.TWO_BOOKS_NOT_IMPORTED
import com.salestaxesprolem.tests.TestConstants.TWO_MUSIC_CD_NOT_IMPORTED
import com.salestaxesprolem.ticketprinting.TicketPrinterFactory
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SalesTest {

    @Test
    fun `given empty basket then ticket is empty`() {
        // Given
        val order = Basket(emptyList())
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """Sales Taxes: 0.00
            |Total: 0.00
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 book at 12_49 then no tax is applied`() {
        // Given
        val order = Basket(mutableListOf(ONE_BOOK_NOT_IMPORTED))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """1 book: 12.49
            |Sales Taxes: 0.00
            |Total: 12.49
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 chocolate bar at 0_85 then no tax is applied`() {
        // Given
        val order = Basket(mutableListOf(ONE_CHOCOLATE_BAR_NOT_IMPORTED))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """1 chocolate bar: 0.85
            |Sales Taxes: 0.00
            |Total: 0.85
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 book at 12_49 and 1 chocolate bar at 0_85 then no tax is applied`() {
        // Given
        val order = Basket(mutableListOf(ONE_BOOK_NOT_IMPORTED, ONE_CHOCOLATE_BAR_NOT_IMPORTED))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """1 book: 12.49
            |1 chocolate bar: 0.85
            |Sales Taxes: 0.00
            |Total: 13.34
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 music CD at 14_99 then the basic tax is applied`() {
        // Given
        val order = Basket(mutableListOf(ONE_MUSIC_CD_NOT_IMPORTED))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """1 music CD: 16.49
            |Sales Taxes: 1.50
            |Total: 16.49
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 2 music CD at 14_99 then the basic tax is applied`() {
        // Given
        val order = Basket(mutableListOf(TWO_MUSIC_CD_NOT_IMPORTED))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """2 music CD: 32.98
            |Sales Taxes: 3.00
            |Total: 32.98
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `test with 2 books and 1 music CD and 1 chocolate bar`() {
        // Given
        val order =
            Basket(mutableListOf(TWO_BOOKS_NOT_IMPORTED, ONE_MUSIC_CD_NOT_IMPORTED, ONE_CHOCOLATE_BAR_NOT_IMPORTED))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """2 book: 24.98
            |1 music CD: 16.49
            |1 chocolate bar: 0.85
            |Sales Taxes: 1.50
            |Total: 42.32
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given one imported product then import tax is applied`() {
        // Given
        val order = Basket(mutableListOf(ONE_IMPORTED_BOX_OF_CHOCOLATES_AT_10F))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """1 imported box of chocolates: 10.50
            |Sales Taxes: 0.50
            |Total: 10.50
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `test with 1 imported box of chocolates and 1 imported bottle of perfume`() {
        // Given
        val order =
            Basket(mutableListOf(ONE_IMPORTED_BOX_OF_CHOCOLATES_AT_10F, ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_47_5F))
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """1 imported box of chocolates: 10.50
            |1 imported bottle of perfume: 54.65
            |Sales Taxes: 7.65
            |Total: 65.15
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `test with imported proucts with and without tax and not imported products with and without tax`() {
        // Given
        val order = Basket(
            mutableListOf(
                ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_27_99F,
                ONE_BOTTLE_OF_PERFUME_NOT_IMPORTED,
                ONE_PACKET_OF_HEADACHE_PILLS_NOT_IMPORTED,
                THREE_IMPORTED_BOXES_OF_CHOCOLATES_AT_11_25F
            )
        )
        val ticketPrinterStrategy = TicketPrinterFactory.create(order)

        // When
        val result = ticketPrinterStrategy.print()

        // Then
        val ticketExpected = """1 imported bottle of perfume: 32.19
            |1 bottle of perfume: 20.89
            |1 packet of headache pills: 9.75
            |3 imported box of chocolates: 35.40
            |Sales Taxes: 7.75
            |Total: 98.23
        """.trimMargin()
        assertEquals(ticketExpected, result)
    }
}