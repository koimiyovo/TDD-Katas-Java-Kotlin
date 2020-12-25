package com.string_calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class Calculator2Test {

    @Test
    fun `should return 0 on empty input`() {
        assertEquals(0, Calculator.add(""))
    }

    @Test
    fun `should return number on one number`() {
        assertEquals(1, Calculator.add("1"))
        assertEquals(2, Calculator.add("2"))
    }

    @Test
    fun `should return sum on two numbers`() {
        assertEquals(3, Calculator.add("1,2"))
        assertEquals(7, Calculator.add("3,4"))
        assertEquals(45, Calculator.add("18,27"))
    }

    @Test
    fun `should return sum on unknown amount of numbers`() {
        assertEquals(6, Calculator.add("1,2,3"))
        assertEquals(11, Calculator.add("3,5,2,1"))
        assertEquals(143, Calculator.add("12,34,87,1,9"))
    }

    @Test
    fun `should handle new lines as separator between numbers`() {
        assertEquals(6, Calculator.add("1\n2,3"))
        assertEquals(59, Calculator.add("7,8\n9,15,20"))
    }

    @Test
    fun `should support custom delimiter`() {
        assertEquals(3, Calculator.add("//;\n1;2"))
        assertEquals(60, Calculator.add("//#\n32#25#3"))
    }

    @Test
    fun `should throw an RuntimeException with negative numbers and show all negative numbers in exception message`() {
        val exception = assertThrows<RuntimeException> {
            Calculator.add("2,-3,4,-5")
        }
        assertEquals("Negatives are not allowed: -3,-5", exception.message)
    }

    @Test
    fun `should ignore numbers bigger than 1000`() {
        assertEquals(2, Calculator.add("2,1001"))
        assertEquals(98, Calculator.add("98,4500"))
    }
}