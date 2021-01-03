package com.tdd_by_example.money

abstract class Money(protected val amount: Int) {

    companion object {
        fun dollar(amount: Int): Money = Dollar(amount)

        fun franc(amount: Int): Money = Franc(amount)
    }

    abstract fun times(multiplier: Int): Money

    override fun equals(other: Any?): Boolean {
        return if (other is Money) {
            this.amount == other.amount && this::class == other::class
        } else {
            false
        }
    }
}