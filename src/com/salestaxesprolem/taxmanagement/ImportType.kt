package com.salestaxesprolem.taxmanagement

abstract class ImportType(val percentage: Float)

class Imported : ImportType(0.05F)

class NotImported : ImportType(0F)
