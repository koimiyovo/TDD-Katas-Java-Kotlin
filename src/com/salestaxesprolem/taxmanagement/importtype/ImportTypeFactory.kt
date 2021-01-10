package com.salestaxesprolem.taxmanagement.importtype

object ImportTypeFactory {
    fun create(importType: ImportType): ImportStrategy {
        return when (importType) {
            ImportType.NOT_IMPORTED -> {
                NotImportedStrategy()
            }
            else -> {
                ImportedStrategy()
            }
        }
    }
}