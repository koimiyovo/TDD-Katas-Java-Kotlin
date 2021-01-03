package com.tdd_by_example.money

class Franc(private val amount: Int) {
    fun times(multiplier: Int) = Franc(amount * multiplier)

    override fun equals(other: Any?): Boolean {
        return if (other is Franc) {
            this.amount == other.amount
        } else {
            false
        }
    }
}
