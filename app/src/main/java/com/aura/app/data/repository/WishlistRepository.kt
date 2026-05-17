package com.aura.app.data.repository

import com.aura.app.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object WishlistRepository {

    private val _ids = MutableStateFlow<Set<String>>(emptySet())
    val ids: StateFlow<Set<String>> = _ids.asStateFlow()

    fun toggle(productId: String) {
        _ids.value = if (productId in _ids.value) _ids.value - productId
                     else _ids.value + productId
    }

    fun contains(productId: String): Boolean = productId in _ids.value

    fun products(): List<Product> = MockCatalogue.products.filter { it.id in _ids.value }
}
