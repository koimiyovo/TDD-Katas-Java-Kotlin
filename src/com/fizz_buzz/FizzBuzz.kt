package com.fizz_buzz

object FizzBuzz {
    fun print(maxRange: Int): String {
        val result = StringBuilder()
        for (i in 1..maxRange) {
            result.appendLine(get(i))
        }
        return result.trimEnd().toString()
    }

    fun get(number: Int): String {
        return when {
            number.isMultipleOf(15) -> {
                "FizzBuzz"
            }
            number.isMultipleOf(3) -> {
                "Fizz"
            }
            number.isMultipleOf(5) -> {
                "Buzz"
            }
            else -> {
                number.toString()
            }
        }
    }

    fun get2(number: Int): String {
        val output = StringBuilder()

        if (number.isMultipleOf(3)) {
            output.append("Fizz")
        }
        if (number.isMultipleOf(5)) {
            output.append("Buzz")
        }
        if (output.isEmpty()) {
            output.append(number)
        }
        return output.toString()
    }

    private fun Int.isMultipleOf(number: Int) = this % number == 0
}
