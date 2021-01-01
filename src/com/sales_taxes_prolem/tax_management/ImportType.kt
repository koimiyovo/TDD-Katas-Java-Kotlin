package com.sales_taxes_prolem.tax_management

abstract class ImportType(val percentage: Float)

class Imported : ImportType(0.05F)

class NotImported : ImportType(0F)
