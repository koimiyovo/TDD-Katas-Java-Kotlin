package com.tdd_by_example.money

interface Expression {
    fun reduce(bank: Bank, to: String): Money
}
