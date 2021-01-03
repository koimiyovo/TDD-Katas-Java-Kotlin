package com.tdd_by_example.money

open class Money(protected val amount: Int, protected val currency: String) {

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")

        fun franc(amount: Int): Money = Money(amount, "CHF")
    }

    open fun times(multiplier: Int): Money = Money(amount * multiplier, currency)

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