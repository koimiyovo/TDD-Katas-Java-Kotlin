package com.string_calculator

class MyInput(private var input: String) {
    private val delimiters = mutableSetOf(",", "\n")

    internal fun extractNumbers(): List<Int> {
        this.extractDelimiters()
        this.convertEmptyInput()
        return input.split(delimiters).toIntList()
    }

    private fun convertEmptyInput() = apply { if (input.isEmpty()) input = "0" }

    private fun extractDelimiters() {
        if (this.usesCustomDelimiterSyntax()) {
            val delimiterPart = getDelimiterPart()
            if (delimiterPart.isOfOneLength()) {
                delimiters.add(delimiterPart)
            } else {
                delimiterPart.extractCustomDelimiters()
            }
            input = this.secondLine()
        }
    }

    private fun secondLine() = input.substring(input.indexOf("\n") + 1)

    private fun String.extractCustomDelimiters() {
        var delimiter = this
        while (delimiter.containsDelimiter()) {
            val oneDelimiter =
                delimiter.substring(delimiter.indexOf("[") + 1, delimiter.indexOf("]"))
            delimiters.add(oneDelimiter)
            delimiter = delimiter.lookForNextDelimiter()
        }
    }

    private fun getDelimiterPart() = input.substring(input.indexOf("//") + 2, input.indexOf("\n"))

    private fun String.isOfOneLength() = length == 1

    private fun String.containsDelimiter() = contains("[")

    private fun String.lookForNextDelimiter() = this.substring(this.indexOf("]") + 1)

    private fun usesCustomDelimiterSyntax() = input.startsWith("//")

    private fun String.split(delimiters: MutableSet<String>): List<String> = split(*delimiters.toTypedArray())

    private fun List<String>.toIntList(): List<Int> = map { it.toInt() }
}
