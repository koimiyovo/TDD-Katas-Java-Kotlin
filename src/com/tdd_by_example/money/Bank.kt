package com.tdd_by_example.money

import java.util.*

class Bank {

    private val rates: Hashtable<Pair, Int> = Hashtable()

    fun reduce(source: Expression, to: String): Money {
        return source.reduce(this, to)
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates[Pair(from, to)] = rate
    }

    fun rate(from: String, to: String): Int {
        return if (from == to) {
            1
        } else {
            rates[Pair(from, to)]!!
        }
    }
}
