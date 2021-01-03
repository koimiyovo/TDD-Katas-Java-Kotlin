package com.tdd_by_example.money

class Money(internal val amount: Int, private val currency: String) : Expression {

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")

        fun franc(amount: Int) = Money(amount, "CHF")
    }

    override fun times(multiplier: Int): Expression = Money(amount * multiplier, currency)

    override fun plus(addend: Expression): Expression = Sum(this, addend)

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