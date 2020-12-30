package com.fizz_buzz

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class FizzBuzzTest {
    @Test
    fun `given 1 then return 1`() {
        assertEquals("1", FizzBuzz.get(1))
    }

    @Test
    fun `given 2 then return 2`() {
        assertEquals("2", FizzBuzz.get(2))
    }

    @Test
    fun `given 3 then return Fizz`() {
        assertEquals("Fizz", FizzBuzz.get(3))
    }

    @Test
    fun `given 6 then return Fizz`() {
        assertEquals("Fizz", FizzBuzz.get(6))
    }

    @Test
    fun `given 5 then return Buzz`() {
        assertEquals("Buzz", FizzBuzz.get(5))
    }

    @Test
    fun `given 10 then return Buzz`() {
        assertEquals("Buzz", FizzBuzz.get(10))
    }

    @Test
    fun `given 15 then return FizzBuzz`() {
        assertEquals("FizzBuzz", FizzBuzz.get(15))
    }

    @Test
    fun `given 30 then return FizzBuzz`() {
        assertEquals("FizzBuzz", FizzBuzz.get(30))
    }

    @Test
    fun `test print to 15`() {
        val expected = """1
            |2
            |Fizz
            |4
            |Buzz
            |Fizz
            |7
            |8
            |Fizz
            |Buzz
            |11
            |Fizz
            |13
            |14
            |FizzBuzz
        """.trimMargin()

        assertEquals(expected, FizzBuzz.print(15))
    }
}