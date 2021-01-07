package com.salestaxesprolem.taxmanagement

abstract class TaxType(val percentage: Float)

class BasicTax : TaxType(0.1F)

class NoTax : TaxType(0F)
