package com.salestaxesprolem.utils

import kotlin.math.roundToInt

object Rounder
{
    fun Float.roundToNearest005() = (this * 20).roundToInt() / 20.0F
}