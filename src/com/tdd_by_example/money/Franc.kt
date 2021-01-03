package com.tdd_by_example.money

class Franc(amount: Int) : Money(amount) {

    fun times(multiplier: Int) = Franc(amount * multiplier)
}
