package com.tdd_by_example.money

class Dollar(var amount: Int) {

    fun times(multiplier: Int) = Dollar(amount * multiplier)

}
