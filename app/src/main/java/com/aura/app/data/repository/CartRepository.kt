package com.aura.app.data.repository

import com.aura.app.data.model.CartItem
import com.aura.app.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * In-memory cart. Real implementations would persist to Room / DataStore /
 * a remote endpoint — the public surface area is the same.
 */
object CartRepository {

    private val _items = MutableStateFlow<List<CartItem>>(emptyList())
    val items: StateFlow<List<CartItem>> = _items.asStateFlow()

    fun add(product: Product, size: String) {
        val current = _items.value.toMutableList()
        val existing = current.indexOfFirst { it.product.id == product.id && it.size == size }
        if (existing >= 0) {
            val it = current[existing]
            current[existing] = it.copy(quantity = it.quantity + 1)
        } else {
            current += CartItem(product, size, 1)
        }
        _items.value = current
    }

    fun remove(productId: String, size: String) {
        _items.value = _items.value.filterNot { it.product.id == productId && it.size == size }
    }

    fun updateQuantity(productId: String, size: String, qty: Int) {
        if (qty <= 0) { remove(productId, size); return }
        _items.value = _items.value.map {
            if (it.product.id == productId && it.size == size) it.copy(quantity = qty) else it
        }
    }

    fun clear() { _items.value = emptyList() }

    fun subtotalCents(): Long = _items.value.sumOf { it.lineTotalCents }

    fun count(): Int = _items.value.sumOf { it.quantity }
}
