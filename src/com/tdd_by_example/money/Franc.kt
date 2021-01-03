package com.tdd_by_example.money

class Franc(amount: Int) : Money(amount) {

    override fun times(multiplier: Int): Money = Franc(amount * multiplier)
}
