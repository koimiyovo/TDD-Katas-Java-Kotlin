package com.tdd_by_example.money

interface Expression {
    fun reduce(bank: Bank, to: String): Money

    fun plus(addend: Expression): Expression

    fun times(multiplier: Int): Expression
}
