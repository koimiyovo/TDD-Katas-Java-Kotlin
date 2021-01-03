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
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun `test equality`() {
        assertAll(
            { assertTrue(Money.dollar(5).equals(Money.dollar(5))) },
            { assertFalse(Money.dollar(5).equals(Money.dollar(6))) },

            { assertTrue(Money.franc(5).equals(Money.franc(5))) },
            { assertFalse(Money.franc(5).equals(Money.franc(6))) },

            { assertFalse(Money.franc(5).equals(Money.dollar(5))) }
        )
    }

    @Test
    fun `test franc multiplication`() {
        val five = Money.franc(5)
        assertEquals(Money.franc(10), five.times(2))
        assertEquals(Money.franc(15), five.times(3))
    }
}