package com.tdd_by_example.money

interface Expression {
    fun reduce(to: String): Money
}
