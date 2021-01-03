package com.tdd_by_example.money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

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
            { assertEquals(Money.dollar(5), (Money.dollar(5))) },
            { assertNotEquals(Money.dollar(5), Money.dollar(6)) },
            { assertNotEquals(Money.franc(5), (Money.dollar(5))) }
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

    @Test
    fun `test plus returns sum`() {
        val five = Money.dollar(5)
        val result: Expression = five.plus(five)
        val sum: Sum = result as Sum
        assertAll(
            { assertEquals(five, sum.augend) },
            { assertEquals(five, sum.addend) },
        )
    }

    @Test
    fun `test reduce sum`() {
        val sum: Expression = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()
        val result: Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(7), result)
    }

    @Test
    fun `test reduce money`() {
        val bank = Bank()
        val result = bank.reduce(Money.dollar(1), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun `test reduce money with different currency`() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun `test identity rate`() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }
}