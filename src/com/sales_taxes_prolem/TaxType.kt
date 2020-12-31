package com.sales_taxes_prolem

open class TaxType(val percentage: Float)

class BasicTax : TaxType(0.1F)

class NoTax : TaxType(0F)
