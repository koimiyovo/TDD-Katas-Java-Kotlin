package com.string_calculator

object Calculator {
    fun add(input: String) =
        Input(input)
            .extractNumbers()
            .ignoreNumbersBiggerThan(1000)
            .throwExceptionOnNegativeNumbers()
            .sum()

    private fun List<Int>.ignoreNumbersBiggerThan(number: Int) = filter { it <= number }

    private fun List<Int>.throwExceptionOnNegativeNumbers(): List<Int> = apply {
        val negatives = filter { it < 0 }
        if (negatives.isNotEmpty()) {
            throw RuntimeException("Negatives not allowed: ${negatives.joinToString(",")}")
        }
    }
}

class Input(private var input: String) {
    internal fun extractNumbers(): List<Int> {
        this.convertEmptyInput()
        val defaultDelimiters = mutableListOf(",", "\n")
        if (this.usesCustomDelimiterSyntax()) {
            val customDelimiter = this.extractDelimiter()
            customDelimiter.forEach { defaultDelimiters.add(it) }
            input = this.secondLine()
        }
        return input.split(defaultDelimiters).toIntList()
    }

    private fun convertEmptyInput() = apply { if (input.isEmpty()) input = "0" }

    private fun usesCustomDelimiterSyntax() = input.startsWith("//")

    private fun extractDelimiter(): Delimiter {
        var delimiter = Delimiter(listOf(input.substring(input.indexOf("//") + 2, input.indexOf("\n"))))
        if (delimiter.isOfAnyLength()) {
            val delimiters = this.allDelimiters()
            delimiter = Delimiter(delimiters)
        }
        return delimiter
    }

    private fun allDelimiters(): List<String> {
        val delimiters = mutableListOf<String>()
        while (this.hasDelimiter()) {
            val delimiter = input.substring(input.indexOf("[") + 1, input.indexOf("]"))
            delimiters.add(delimiter)
            this.lookForNextDelimiter()
        }
        return delimiters
    }

    private fun hasDelimiter() = input.contains("[")

    private fun lookForNextDelimiter() {
        input = input.substring(input.indexOf("]") + 1)
    }

    private fun secondLine() = input.substring(input.indexOf("\n") + 1)

    private fun String.split(delimiters: List<String>) = split(*delimiters.toTypedArray())

    private fun List<String>.toIntList(): List<Int> = map { it.toInt() }
}

class Delimiter(private val delimiters: List<String>) : Iterable<String> {
    internal fun isOfAnyLength() = delimiters.any { it.contains("[") }

    override fun iterator(): Iterator<String> = delimiters.iterator()
}