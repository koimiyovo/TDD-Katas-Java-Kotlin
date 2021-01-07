package com.salestaxesprolem

import com.salestaxesprolem.taxmanagement.*
import com.salestaxesprolem.ticketprinting.EmptyTicket
import com.salestaxesprolem.ticketprinting.EmptyTicketPrinter
import com.salestaxesprolem.ticketprinting.TextTicket
import com.salestaxesprolem.ticketprinting.TextTicketPrinter
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SaleTest {
    @Test
    fun `given one product at price of 10 exampt of tax and not imported then price including VAT is 10`() {
        // Given
        val item = OrderItem(Product("product", 10F, NoTax(), NotImported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(10F, priceAllTaxesIncluded)
    }

    @Test
    fun `given one product at price of 15 exampt of tax and not imported then price including VAT is 15`() {
        // Given
        val item = OrderItem(Product("product", 15F, NoTax(), NotImported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(15F, priceAllTaxesIncluded)
    }

    @Test
    fun `given one product at price of 10 with basic tax and not imported then price including VAT is 11`() {
        // Given
        val item = OrderItem(Product("product", 10F, BasicTax(), NotImported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(11F, priceAllTaxesIncluded)
    }

    @Test
    fun `given one product at price of 15 with basic tax and not imported then price including VAT is 16_5`() {
        // Given
        val item = OrderItem(Product("product", 15F, BasicTax(), NotImported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(16.5F, priceAllTaxesIncluded)
    }

    @Test
    fun `given one product at price of 10 exampt of tax and imported then price including VAT is 10_5`() {
        // Given
        val item = OrderItem(Product("product", 10F, NoTax(), Imported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(10.5F, priceAllTaxesIncluded)
    }

    @Test
    fun `given one product at price of 15 exampt of tax and imported then price including VAT is 15_75`() {
        // Given
        val item = OrderItem(Product("product", 15F, NoTax(), Imported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(15.75F, priceAllTaxesIncluded)
    }

    @Test
    fun `given one product at price of 10 with basic tax and imported then price including VAT is 11_5`() {
        // Given
        val item = OrderItem(Product("product", 10F, BasicTax(), Imported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(11.5F, priceAllTaxesIncluded)
    }

    @Test
    fun `given one product at price of 15 with basic tax and imported then price including VAT is 17_25`() {
        // Given
        val item = OrderItem(Product("product", 15F, BasicTax(), Imported()), 1)

        // When
        val priceAllTaxesIncluded = item.priceIncludingTaxes()

        // Then
        assertEquals(17.25F, priceAllTaxesIncluded)
    }

    @Test
    fun `given empty input then ticket is empty`() {
        // Given
        val ticketExpected = """Sales Taxes: 0.00
            |Total: 0.00
        """.trimMargin()

        // When
        val ticket = EmptyTicket()
        val ticketPrinter = EmptyTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 book at 12_49 then no tax is applied`() {
        // Given
        val book = OrderItem(Product("book", 12.49F, taxType = NoTax(), importType = NotImported()), 1)

        val orderItems = mutableListOf(book)

        val order = Order(orderItems)
        val ticketExpected = """1 book: 12.49
            |Sales Taxes: 0.00
            |Total: 12.49
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 chocolate bar at 0_85 then no tax is applied`() {
        // Given
        val chocolateBar = OrderItem(Product("chocolate bar", 0.85F, taxType = NoTax(), importType = NotImported()), 1)

        val orderItems = mutableListOf(chocolateBar)

        val order = Order(orderItems)
        val ticketExpected = """1 chocolate bar: 0.85
            |Sales Taxes: 0.00
            |Total: 0.85
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 book at 12_49 and 1 chocolate bar at 0_85 then no tax is applied`() {
        // Given
        val book = OrderItem(Product("book", 12.49F, taxType = NoTax(), importType = NotImported()), 1)
        val chocolateBar = OrderItem(Product("chocolate bar", 0.85F, taxType = NoTax(), importType = NotImported()), 1)

        val orderItems = mutableListOf(book, chocolateBar)

        val order = Order(orderItems)
        val ticketExpected = """1 book: 12.49
            |1 chocolate bar: 0.85
            |Sales Taxes: 0.00
            |Total: 13.34
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 1 music CD at 14_99 then the basic tax is applied`() {
        // Given
        val musicCD = OrderItem(Product("music CD", 14.99F, taxType = BasicTax(), importType = NotImported()), 1)

        val orderItems = mutableListOf(musicCD)

        val order = Order(orderItems)
        val ticketExpected = """1 music CD: 16.49
            |Sales Taxes: 1.50
            |Total: 16.49
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given 2 music CD at 14_99 then the basic tax is applied`() {
        // Given
        val musicCD = OrderItem(Product("music CD", 14.99F, taxType = BasicTax(), importType = NotImported()), 2)

        val orderItems = mutableListOf(musicCD)

        val order = Order(orderItems)
        val ticketExpected = """2 music CD: 32.98
            |Sales Taxes: 3.00
            |Total: 32.98
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `test with 2 books and 1 music CD and 1 chocolate bar`() {
        // Given
        val book = OrderItem(Product("book", 12.49F, taxType = NoTax(), importType = NotImported()), 2)
        val musicCD = OrderItem(Product("music CD", 14.99F, taxType = BasicTax(), importType = NotImported()), 1)
        val chocolateBar = OrderItem(Product("chocolate bar", 0.85F, taxType = NoTax(), importType = NotImported()), 1)

        val orderItems = mutableListOf(book, musicCD, chocolateBar)

        val order = Order(orderItems)
        val ticketExpected = """2 book: 24.98
            |1 music CD: 16.49
            |1 chocolate bar: 0.85
            |Sales Taxes: 1.50
            |Total: 42.32
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `given one imported product then import tax is applied`() {
        // Given
        val importedBoxOfChocolates =
            OrderItem(Product("imported box of chocolates", 10F, taxType = NoTax(), importType = Imported()), 1)

        val orderItems = mutableListOf(importedBoxOfChocolates)

        val order = Order(orderItems)
        val ticketExpected = """1 imported box of chocolates: 10.50
            |Sales Taxes: 0.50
            |Total: 10.50
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `test with 1 imported box of chocolates and 1 imported bottle of perfume`() {
        // Given
        val importedBoxOfChocolates =
            OrderItem(Product("imported box of chocolates", 10F, taxType = NoTax(), importType = Imported()), 1)
        val importedBottleOfPerfume =
            OrderItem(Product("imported bottle of perfume", 47.5F, taxType = BasicTax(), importType = Imported()), 1)

        val orderItems = mutableListOf(importedBoxOfChocolates, importedBottleOfPerfume)

        val order = Order(orderItems)
        val ticketExpected = """1 imported box of chocolates: 10.50
            |1 imported bottle of perfume: 54.65
            |Sales Taxes: 7.65
            |Total: 65.15
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }

    @Test
    fun `test with imported proucts with and without tax and not imported products with and without tax`() {
        // Given
        val importedBottleOfPerfume =
            OrderItem(Product("imported bottle of perfume", 27.99F, taxType = BasicTax(), importType = Imported()), 1)
        val notImportedBottleOfPerfume =
            OrderItem(Product("bottle of perfume", 18.99F, taxType = BasicTax(), importType = NotImported()), 1)
        val packetOfHeadachePills =
            OrderItem(Product("packet of headache pills", 9.75F, taxType = NoTax(), importType = NotImported()), 1)
        val boxOfImportedChocolates =
            OrderItem(Product("imported box of chocolates", 11.25F, taxType = NoTax(), importType = Imported()), 3)

        val orderItems =
            mutableListOf(
                importedBottleOfPerfume,
                notImportedBottleOfPerfume,
                packetOfHeadachePills,
                boxOfImportedChocolates
            )

        val order = Order(orderItems)
        val ticketExpected = """1 imported bottle of perfume: 32.19
            |1 bottle of perfume: 20.89
            |1 packet of headache pills: 9.75
            |3 imported box of chocolates: 35.40
            |Sales Taxes: 7.75
            |Total: 98.23
        """.trimMargin()

        // When
        val ticket = TextTicket(order)
        val ticketPrinter = TextTicketPrinter(ticket)
        val result = ticketPrinter.print()

        // Then
        assertEquals(ticketExpected, result)
    }
}