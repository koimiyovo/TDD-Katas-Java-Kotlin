package com.tdd_by_example.money

class Dollar(private val amount: Int) {

    fun times(multiplier: Int) = Dollar(amount * multiplier)

    override fun equals(other: Any?): Boolean {
        return if (other is Dollar) {
            this.amount == other.amount
        } else {
            false
        }
    }
}
