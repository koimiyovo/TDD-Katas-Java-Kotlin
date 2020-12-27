package com.string_calculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class CalculatorTest {
    @Test
    fun `empty input should return 0`() {
        assertEquals(0, Calculator.add(""))
    }

    @Test
    fun `should return number on one number as input`() {
        assertAll(
            { assertEquals(1, Calculator.add("1")) },
            { assertEquals(2, Calculator.add("2")) },
        )
    }

    @Test
    fun `should return sum on two numbers as input separated by comma`() {
        assertAll(
            { assertEquals(3, Calculator.add("1,2")) },
            { assertEquals(9, Calculator.add("5,4")) }
        )
    }

    @Test
    fun `should handle an unknown amount of numbers as input separated by commas`() {
        assertAll(
            { assertEquals(6, Calculator.add("1,2,3")) },
            { assertEquals(30, Calculator.add("9,6,12,3")) }
        )
    }

    @Test
    fun `should accept new lines between numbers as delimiters instead of commas`() {
        assertAll(
            { assertEquals(6, Calculator.add("1\n2\n3")) },
            { assertEquals(30, Calculator.add("9\n6\n12\n3")) }
        )
    }

    @Test
    fun `should mix new lines and commas as delimiters`() {
        assertAll(
            { assertEquals(6, Calculator.add("1\n2,3")) },
            { assertEquals(30, Calculator.add("9,6\n12,3")) }
        )
    }

    @Test
    fun `should support custom delimiter with the particular format`() {
        assertAll(
            { assertEquals(3, Calculator.add("//;\n1;2")) },
            { assertEquals(6, Calculator.add("//-\n1-2-3")) },
        )
    }

    @Test
    fun `should support custom delimiter and commas and new lines`() {
        assertAll(
            { assertEquals(6, Calculator.add("//;\n1;2,3")) },
            { assertEquals(10, Calculator.add("//-\n1,2-3,4")) },
            { assertEquals(10, Calculator.add("//-\n1,2-3\n4")) },
        )
    }

    @Test
    fun `should throw an exception with negative numbers and show all negative numbers in exception message`() {
        assertAll(
            {
                assertThrows<RuntimeException> {
                    Calculator.add("2,-3,4,-5")
                }.run {
                    Assertions.assertEquals("Negatives not allowed: -3,-5", message)
                }
            },
            {
                assertThrows<RuntimeException> {
                    Calculator.add("-12,32,1,-1,4,-8,9")
                }.run {
                    Assertions.assertEquals("Negatives not allowed: -12,-1,-8", message)
                }
            },
        )
    }

    @Test
    fun `should ignore numbers bigger than 1000`() {
        assertAll(
            { assertEquals(2, Calculator.add("2,1001")) },
            { assertEquals(18, Calculator.add("18,5000")) },
        )
    }

    @Test
    fun `delimiters can be of any length with the particular format`() {
        assertAll(
            { assertEquals(6, Calculator.add("//[***]\n1***2***3")) },
            { assertEquals(6, Calculator.add("//[##]\n1##2##3")) },
        )
    }

    @Test
    fun `should allow multiple delimiters with the particular format`() {
        assertAll(
            { assertEquals(6, Calculator.add("//[*][%]\n1*2%3")) },
            { assertEquals(21, Calculator.add("//[*][%][-]\n1*2%3-4*5-6")) },
        )
    }

    @Test
    fun `should allow multiple delimiters with length longer than one char with the particular format`() {
        assertAll(
            { assertEquals(6, Calculator.add("//[**][%%%]\n1**2%%%3")) },
            { assertEquals(21, Calculator.add("//[*][%%][----]\n1*2%%3----4*5----6")) },
        )
    }
}