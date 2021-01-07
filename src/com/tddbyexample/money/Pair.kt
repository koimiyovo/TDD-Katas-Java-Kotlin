package com.tddbyexample.money

class Pair(private val from: String, private val to: String) {
    override fun equals(other: Any?): Boolean {
        return if (other is Pair) {
            from == other.from && to == other.to
        } else {
            false
        }
    }

    override fun hashCode(): Int = 0
}