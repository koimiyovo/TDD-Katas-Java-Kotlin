package com.tdd_by_example.money

open class Money(protected val amount: Int) {
    override fun equals(other: Any?): Boolean {
        return if (other is Money) {
            this.amount == other.amount
        } else {
            false
        }
    }
}