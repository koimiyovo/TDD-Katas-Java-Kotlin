package com.sales_taxes_prolem

class OrderItem(private val product: Product, private val quantity: Int) {
    fun totalTTC(): Float {
        return product.price * quantity;
    }

    fun resume(): String = "$quantity ${product.name}: ${totalTTC()}"
}
