package com.string_calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MyInputTest {
    @Test
    fun `test extract numbers with commas`() {
        val expected = listOf(1, 2, 3)
        val result = MyInput("1,2,3").extractNumbers()
        assertEquals(expected, result)
    }

    @Test
    fun `test extract numbers with new lines`() {
        val expected = listOf(1, 2, 3)
        val result = MyInput("1\n2\n3").extractNumbers()
        assertEquals(expected, result)
    }

    @Test
    fun `test extract numbers with commas and new lines`() {
        val expected = listOf(1, 2, 3, 4)
        val result = MyInput("1,2\n3,4").extractNumbers()
        assertEquals(expected, result)
    }

    @Test
    fun `test extract numbers with custom delimiter of one length`() {
        val expected = listOf(1, 2, 3)
        val result = MyInput("//;\n1;2;3").extractNumbers()
        assertEquals(expected, result)
    }

    @Test
    fun `test extract numbers with comma and custom delimiter of one length`() {
        val expected = listOf(1, 2, 3)
        val result = MyInput("//;\n1;2,3").extractNumbers()
        assertEquals(expected, result)
    }

    @Test
    fun `test extract numbers with custom delimiter of any length`() {
        val expected = listOf(1, 2, 3)
        val result = MyInput("//[***]\n1***2***3").extractNumbers()
        assertEquals(expected, result)
    }

    @Test
    fun `test extract numbers with multiple delimiter of one length`() {
        val expected = listOf(1, 2, 3)
        val result = MyInput("//[*][%]\n1*2%3").extractNumbers()
        assertEquals(expected, result)
    }

    @Test
    fun `test extract numbers with multiple delimiter of any length`() {
        val expected = listOf(1, 2, 3)
        val result = MyInput("//[***][%%]\n1***2%%3").extractNumbers()
        assertEquals(expected, result)
    }
}