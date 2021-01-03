package com.tdd_by_example.money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class MoneyTest {
    @Test
    fun `test multiplication`() {
        val five = Dollar(5)
        assertEquals(Dollar(10), five.times(2))
        assertEquals(Dollar(15), five.times(3))
    }

    @Test
    fun `test equality`() {
        assertAll(
            { assertTrue(Dollar(5).equals(Dollar(5))) },
            { assertFalse(Dollar(5).equals(Dollar(6))) },

            { assertTrue(Franc(5).equals(Franc(5))) },
            { assertFalse(Franc(5).equals(Franc(6))) }
        )
    }

    @Test
    fun `test franc multiplication`() {
        val five = Franc(5)
        assertEquals(Franc(10), five.times(2))
        assertEquals(Franc(15), five.times(3))
    }
}