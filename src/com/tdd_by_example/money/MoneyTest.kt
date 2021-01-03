package com.tdd_by_example.money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class MoneyTest {
    @Test
    fun `test multiplication`() {
        val five: Money = Money.dollar(5)
        assertAll(
            { assertEquals(Money.dollar(10), five.times(2)) },
            { assertEquals(Money.dollar(15), five.times(3)) }
        )
    }

    @Test
    fun `test equality`() {
        assertAll(
            { assertTrue(Money.dollar(5) == (Money.dollar(5))) },
            { assertFalse(Money.dollar(5) == Money.dollar(6)) },
            { assertFalse(Money.franc(5) == (Money.dollar(5))) }
        )
    }

    @Test
    fun `test currency`() {
        assertAll(
            { assertEquals("USD", Money.dollar(1).currency()) },
            { assertEquals("CHF", Money.franc(1).currency()) },
        )
    }

    @Test
    fun `test simple addition`() {
        val five = Money.dollar(5)
        val sum: Expression = five.plus(five)
        val bank = Bank()
        val reduced: Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }
}