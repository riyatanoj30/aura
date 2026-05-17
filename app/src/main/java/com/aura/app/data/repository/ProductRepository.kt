package com.aura.app.data.repository

import com.aura.app.data.model.Category
import com.aura.app.data.model.Product

object ProductRepository {
    fun all(): List<Product> = MockCatalogue.products
    fun byId(id: String): Product? = MockCatalogue.byId(id)
    fun byCategory(id: String): List<Product> = MockCatalogue.byCategory(id)
    fun newArrivals(): List<Product> = MockCatalogue.newArrivals()
    fun categories(): List<Category> = MockCatalogue.categories
    fun recommendationsFor(productId: String): List<Product> =
        MockCatalogue.products.filter { it.id != productId }.shuffled().take(4)
}
