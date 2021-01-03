package com.tdd_by_example.money

abstract class Money(protected val amount: Int, protected val currency: String) {

    companion object {
        fun dollar(amount: Int): Money = Dollar(amount, "USD")

        fun franc(amount: Int): Money = Franc(amount, "CHF")
    }

    abstract fun times(multiplier: Int): Money

    fun currency(): String = currency

    override fun equals(other: Any?): Boolean {
        return if (other is Money) {
            this.amount == other.amount && this::class == other::class
        } else {
            false
        }
    }
}