package com.tdd_by_example.money

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
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
        assertTrue(Dollar(5).equals(Dollar(5)))
    }
}