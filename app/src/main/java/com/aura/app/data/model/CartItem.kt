package com.aura.app.data.model

data class CartItem(
    val product: Product,
    val size: String,
    val quantity: Int = 1
) {
    val lineTotalCents: Long get() = product.priceCents * quantity
}
