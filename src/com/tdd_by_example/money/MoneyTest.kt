package com.tdd_by_example.money

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class MoneyTest {
    @Test
    fun `test multiplication`() {
        val five = Dollar(5)
        var product: Dollar = five.times(2)
        assertEquals(10, product.amount)
        product = five.times(3)
        assertEquals(15, product.amount)
    }

    @Test
    fun `test equality`() {
        assertTrue(Dollar(5).equals(Dollar(5)))
    }
}