package com.tdd_by_example.money

class Money(private val amount: Int, private val currency: String) {

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")

        fun franc(amount: Int) = Money(amount, "CHF")
    }

    fun times(multiplier: Int) = Money(amount * multiplier, currency)
    
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