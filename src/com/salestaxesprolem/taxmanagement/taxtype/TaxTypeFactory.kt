package com.salestaxesprolem.taxmanagement.taxtype

object TaxTypeFactory {
    fun create(taxType: TaxType): TaxStrategy {
        return when (taxType) {
            TaxType.NO_TAX -> {
                NoTaxStrategy()
            }
            else -> {
                BasicTaxStrategy()
            }
        }
    }
}