package com.string_calculator

import java.util.regex.Matcher
import java.util.regex.Pattern

class Calculator {
    companion object {
        private const val NEUTRAL_VALUE = 0

        fun add(input: String) = input.extractNumbers()
            .ignoreNumbersBiggerThan(1000)
            .handleNegativeNumbers()
            .sum()

        private fun String.extractNumbers(): List<Int> {
            if (this.isEmpty()) {
                return mutableListOf(NEUTRAL_VALUE)
            } else {
                val input: List<String>
                if (this.usesCustomDelimiterSyntax()) {
                    // TODO: A revoir avec Jasmine
                    val secondLine = this.substring(this.indexOf("\n") + 1)
                    input = secondLine.split(this.extractDelimiter())
                } else {
                    input = this.split(",", "\n")
                }
                return input.convertToListOfInt()
            }
        }

        private fun String.usesCustomDelimiterSyntax() = this.startsWith("""//""")

        private fun String.extractDelimiter(): String {
            val matcher: Matcher = Pattern.compile("""//(.)\n(.*)""").matcher(this)
            matcher.matches()
            return matcher.group(1)
        }

        private fun List<String>.convertToListOfInt(): List<Int> {
            val numbers = mutableListOf<Int>()
            this.forEach { numbers.add(it.toInt()) }
            return numbers
        }

        private fun List<Int>.handleNegativeNumbers(): List<Int> {
            val negatives = this.filter { it < 0 }
            if (negatives.isNotEmpty()) {
                throw RuntimeException("Negatives are not allowed: " + negatives.joinToString(","))
            } else {
                return this
            }
        }

        private fun List<Int>.ignoreNumbersBiggerThan(number: Int): List<Int> {
            return this.filter { it <= number }
        }
    }
}