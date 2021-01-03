package com.tdd_by_example.money

class Money(internal val amount: Int, private val currency: String) : Expression {

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")

        fun franc(amount: Int) = Money(amount, "CHF")
    }

    fun times(multiplier: Int) = Money(amount * multiplier, currency)

    fun plus(addend: Money): Expression = Sum(this, addend)

    override fun reduce(bank: Bank, to: String): Money {
        val rate = bank.rate(currency, to)
        return Money(amount / rate, to)
    }

    fun currency(): String = currency

    override fun equals(other: Any?): Boolean {
        return if (other is Money) {
            this.amount == other.amount && this.currency() == other.currency()
        } else {
            false
        }
    }

    override fun toString() = "$amount $currency"
}