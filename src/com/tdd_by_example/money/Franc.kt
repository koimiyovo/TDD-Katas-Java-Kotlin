package com.tdd_by_example.money

class Franc(amount: Int, currency: String) : Money(amount, currency) {

    override fun times(multiplier: Int): Money = Money.franc(amount * multiplier)
}
