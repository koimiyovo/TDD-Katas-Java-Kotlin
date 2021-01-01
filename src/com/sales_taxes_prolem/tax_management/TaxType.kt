package com.sales_taxes_prolem.tax_management

abstract class TaxType(val percentage: Float)

class BasicTax : TaxType(0.1F)

class NoTax : TaxType(0F)
