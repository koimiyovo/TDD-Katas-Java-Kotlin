package com.salestaxesprolem.tests

import com.salestaxesprolem.tests.TestConstants.ONE_BOOK_NOT_IMPORTED_AT_12_49F
import com.salestaxesprolem.tests.TestConstants.ONE_BOTTLE_OF_PERFUME_NOT_IMPORTED_AT_18_99F
import com.salestaxesprolem.tests.TestConstants.ONE_CHOCOLATE_BAR_NOT_IMPORTED_AT_0_85F
import com.salestaxesprolem.tests.TestConstants.ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_27_99F
import com.salestaxesprolem.tests.TestConstants.ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_47_5F
import com.salestaxesprolem.tests.TestConstants.ONE_IMPORTED_BOX_OF_CHOCOLATES_AT_10F
import com.salestaxesprolem.tests.TestConstants.ONE_MUSIC_CD_NOT_IMPORTED_AT_14_99F
import com.salestaxesprolem.tests.TestConstants.ONE_PACKET_OF_HEADACHE_PILLS_NOT_IMPORTED_AT_9_75F
import com.salestaxesprolem.tests.TestConstants.THREE_IMPORTED_BOXES_OF_CHOCOLATES_AT_11_25F
import com.salestaxesprolem.tests.TestConstants.TWO_BOOKS_NOT_IMPORTED_AT_12_49F
import com.salestaxesprolem.tests.TestConstants.TWO_MUSIC_CD_NOT_IMPORTED_AT_14_99F
import com.salestaxesprolem.tests.gwt.Given
import com.salestaxesprolem.tests.gwt.ThenTicketIs
import com.salestaxesprolem.tests.gwt.WhenPrintTicket
import org.junit.jupiter.api.Test

internal class SalesTest
{

    @Test
    fun `given empty basket then ticket is empty`()
    {
        WhenPrintTicket()

        ThenTicketIs(
            """Sales Taxes: 0.00
                    |Total: 0.00"""
        )
    }

    @Test
    fun `given 1 book then no tax is applied`()
    {
        Given(ONE_BOOK_NOT_IMPORTED_AT_12_49F)

        WhenPrintTicket()

        ThenTicketIs(
            """1 book: 12.49
                    |Sales Taxes: 0.00
                    |Total: 12.49"""
        )
    }

    @Test
    fun `given 1 chocolate bar then no tax is applied`()
    {
        Given(ONE_CHOCOLATE_BAR_NOT_IMPORTED_AT_0_85F)

        WhenPrintTicket()

        ThenTicketIs(
            """1 chocolate bar: 0.85
                    |Sales Taxes: 0.00
                    |Total: 0.85"""
        )
    }

    @Test
    fun `given 1 book and 1 chocolate bar then no tax is applied`()
    {
        Given(ONE_BOOK_NOT_IMPORTED_AT_12_49F, ONE_CHOCOLATE_BAR_NOT_IMPORTED_AT_0_85F)

        WhenPrintTicket()

        ThenTicketIs(
            """1 book: 12.49
                    |1 chocolate bar: 0.85
                    |Sales Taxes: 0.00
                    |Total: 13.34"""
        )
    }

    @Test
    fun `given 1 music CD then the basic tax is applied`()
    {
        Given(ONE_MUSIC_CD_NOT_IMPORTED_AT_14_99F)

        WhenPrintTicket()

        ThenTicketIs(
            """1 music CD: 16.49
                    |Sales Taxes: 1.50
                    |Total: 16.49"""
        )
    }

    @Test
    fun `given 2 music CD then the basic tax is applied`()
    {
        Given(TWO_MUSIC_CD_NOT_IMPORTED_AT_14_99F)

        WhenPrintTicket()

        ThenTicketIs(
            """2 music CD: 32.98
                    |Sales Taxes: 3.00
                    |Total: 32.98"""
        )
    }

    @Test
    fun `test with 2 books and 1 music CD and 1 chocolate bar`()
    {
        Given(
            TWO_BOOKS_NOT_IMPORTED_AT_12_49F,
            ONE_MUSIC_CD_NOT_IMPORTED_AT_14_99F,
            ONE_CHOCOLATE_BAR_NOT_IMPORTED_AT_0_85F
        )

        WhenPrintTicket()

        ThenTicketIs(
            """2 book: 24.98
                    |1 music CD: 16.49
                    |1 chocolate bar: 0.85
                    |Sales Taxes: 1.50
                    |Total: 42.32"""
        )
    }

    @Test
    fun `given one imported product then import tax is applied`()
    {
        Given(ONE_IMPORTED_BOX_OF_CHOCOLATES_AT_10F)

        WhenPrintTicket()

        ThenTicketIs(
            """1 imported box of chocolates: 10.50
                    |Sales Taxes: 0.50
                    |Total: 10.50"""
        )
    }

    @Test
    fun `test with 1 imported box of chocolates and 1 imported bottle of perfume`()
    {
        Given(ONE_IMPORTED_BOX_OF_CHOCOLATES_AT_10F, ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_47_5F)

        WhenPrintTicket()

        ThenTicketIs(
            """1 imported box of chocolates: 10.50
                    |1 imported bottle of perfume: 54.65
                    |Sales Taxes: 7.65
                    |Total: 65.15"""
        )
    }

    @Test
    fun `test with imported products with and without tax and not imported products with and without tax`()
    {
        Given(
            ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_27_99F,
            ONE_BOTTLE_OF_PERFUME_NOT_IMPORTED_AT_18_99F,
            ONE_PACKET_OF_HEADACHE_PILLS_NOT_IMPORTED_AT_9_75F,
            THREE_IMPORTED_BOXES_OF_CHOCOLATES_AT_11_25F
        )

        WhenPrintTicket()

        ThenTicketIs(
            """1 imported bottle of perfume: 32.19
                    |1 bottle of perfume: 20.89
                    |1 packet of headache pills: 9.75
                    |3 imported box of chocolates: 35.40
                    |Sales Taxes: 7.75
                    |Total: 98.23"""
        )
    }
}