package com.tdd_by_example.money

class Dollar(amount: Int) : Money(amount) {

    override fun times(multiplier: Int): Money = Dollar(amount * multiplier)
}
