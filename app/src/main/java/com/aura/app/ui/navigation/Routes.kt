package com.aura.app.ui.navigation

/**
 * Centralised route names. Each screen has one [route]; screens that take
 * arguments compose them via helper builders.
 */
object Routes {
    const val SPLASH      = "splash"
    const val HOME        = "home"
    const val CATEGORY    = "category/{categoryId}"
    const val PRODUCT     = "product/{productId}"
    const val CART        = "cart"
    const val WISHLIST    = "wishlist"
    const val CHECKOUT    = "checkout"
    const val PROFILE     = "profile"
    const val ORDERS      = "orders"
    const val SEARCH      = "search"
    const val SELLER      = "seller"
    const val ADMIN       = "admin"

    fun category(id: String) = "category/$id"
    fun product(id: String)  = "product/$id"
}
