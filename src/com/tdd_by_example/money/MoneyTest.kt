package com.tdd_by_example.money

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MoneyTest {
    @Test
    fun `test multiplication`() {
        val five = Dollar(5)
        five.times(2)
        assertEquals(10, five.amount)
    }
}