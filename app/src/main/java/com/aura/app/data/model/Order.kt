package com.aura.app.data.model

data class Order(
    val id: String,
    val items: List<CartItem>,
    val placedOn: String,
    val totalCents: Long,
    val status: OrderStatus,
    val tracking: String? = null,
    val estimatedDelivery: String
)

enum class OrderStatus(val display: String) {
    PROCESSING("Processing"),
    CRAFTED("Crafted"),
    DISPATCHED("In Transit"),
    DELIVERED("Delivered")
}
