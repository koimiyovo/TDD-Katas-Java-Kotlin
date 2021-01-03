package com.tdd_by_example.money

class Bank {
    fun reduce(source: Expression, to: String): Money {
        return source.reduce(to)
    }
}
