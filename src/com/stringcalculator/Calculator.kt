package com.stringcalculator

object Calculator
{
    fun add(input: String) =
        Input(input)
            .extractNumbers()
            .ignoreNumbersBiggerThan(1000)
            .throwExceptionOnNegativeNumbers()
            .sum()

    private fun List<Int>.ignoreNumbersBiggerThan(number: Int) = filter { it <= number }

    private fun List<Int>.throwExceptionOnNegativeNumbers(): List<Int> = apply {
        val negatives = filter { it < 0 }
        if (negatives.isNotEmpty())
        {
            throw RuntimeException("Negatives not allowed: ${negatives.joinToString(",")}")
        }
    }
}

class Input(private var value: String)
{
    private var separators = mutableSetOf(",", "\n")

    fun extractNumbers(): List<Int>
    {
        this.convertEmptyInput()
        this.extractSeparators()
        return value.split(separators).toIntList()
    }

    private fun convertEmptyInput() = apply { if (value.isEmpty()) value = "0" }

    private fun extractSeparators()
    {
        if (this.usesCustomDelimiterSyntax())
        {
            val delimiterPart = getDelimiterPart()
            if (delimiterPart.isOfOneLength())
            {
                separators.add(delimiterPart.value)
            }
            else
            {
                separators = delimiterPart.getSeparators()
            }
            value = this.secondLine()
        }
    }

    private fun usesCustomDelimiterSyntax() = value.startsWith("//")

    private fun getDelimiterPart() = Input(value.substring(value.indexOf("//") + 2, value.indexOf("\n")))

    private fun isOfOneLength() = value.length == 1

    private fun getSeparators(): MutableSet<String>
    {
        val separators = mutableSetOf<String>()
        while (this.containsSeparator())
        {
            val separator = value.substring(value.indexOf("[") + 1, value.indexOf("]"))
            separators.add(separator)
            lookForTheNextSeparator()
        }
        return separators
    }

    private fun containsSeparator() = value.contains("[")

    private fun lookForTheNextSeparator()
    {
        value = value.substring(value.indexOf("]") + 1)
    }

    private fun secondLine() = value.substring(value.indexOf("\n") + 1)

    private fun String.split(delimiters: MutableSet<String>): List<String> = split(*delimiters.toTypedArray())

    private fun List<String>.toIntList(): List<Int> = map { it.toInt() }
}