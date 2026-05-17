package com.aura.app.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aura.app.ui.screens.admin.AdminDashboardScreen
import com.aura.app.ui.screens.cart.CartScreen
import com.aura.app.ui.screens.category.CategoryScreen
import com.aura.app.ui.screens.checkout.CheckoutScreen
import com.aura.app.ui.screens.home.HomeScreen
import com.aura.app.ui.screens.orders.OrderTrackingScreen
import com.aura.app.ui.screens.product.ProductDetailScreen
import com.aura.app.ui.screens.profile.ProfileScreen
import com.aura.app.ui.screens.search.SearchScreen
import com.aura.app.ui.screens.seller.SellerDashboardScreen
import com.aura.app.ui.screens.splash.SplashScreen
import com.aura.app.ui.screens.wishlist.WishlistScreen

@Composable
fun AuraNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH,
        // Cinematic fade — the cheap "slide-in-from-right" of stock Android
        // would betray the design entirely.
        enterTransition  = { fadeIn(tween(450)) },
        exitTransition   = { fadeOut(tween(220)) },
        popEnterTransition = { fadeIn(tween(350)) },
        popExitTransition  = { fadeOut(tween(220)) }
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(onFinished = {
                navController.navigate(Routes.HOME) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }
            })
        }
        composable(Routes.HOME) {
            HomeScreen(
                onOpenCategory = { id -> navController.navigate(Routes.category(id)) },
                onOpenProduct = { id -> navController.navigate(Routes.product(id)) },
                onOpenCart = { navController.navigate(Routes.CART) },
                onOpenWishlist = { navController.navigate(Routes.WISHLIST) },
                onOpenSearch = { navController.navigate(Routes.SEARCH) },
                onOpenProfile = { navController.navigate(Routes.PROFILE) }
            )
        }
        composable(
            route = Routes.CATEGORY,
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("categoryId") ?: "women"
            CategoryScreen(
                categoryId = id,
                onBack = { navController.popBackStack() },
                onOpenProduct = { pid -> navController.navigate(Routes.product(pid)) },
                onOpenCart = { navController.navigate(Routes.CART) }
            )
        }
        composable(
            route = Routes.PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("productId") ?: "p001"
            ProductDetailScreen(
                productId = id,
                onBack = { navController.popBackStack() },
                onOpenProduct = { pid -> navController.navigate(Routes.product(pid)) },
                onOpenCart = { navController.navigate(Routes.CART) }
            )
        }
        composable(Routes.CART) {
            CartScreen(
                onBack = { navController.popBackStack() },
                onCheckout = { navController.navigate(Routes.CHECKOUT) },
                onContinue = { navController.popBackStack() }
            )
        }
        composable(Routes.CHECKOUT) {
            CheckoutScreen(
                onBack = { navController.popBackStack() },
                onPlaced = {
                    navController.navigate(Routes.ORDERS) {
                        popUpTo(Routes.HOME)
                    }
                }
            )
        }
        composable(Routes.WISHLIST) {
            WishlistScreen(
                onBack = { navController.popBackStack() },
                onOpenProduct = { pid -> navController.navigate(Routes.product(pid)) }
            )
        }
        composable(Routes.PROFILE) {
            ProfileScreen(
                onBack = { navController.popBackStack() },
                onOpenOrders = { navController.navigate(Routes.ORDERS) },
                onOpenWishlist = { navController.navigate(Routes.WISHLIST) },
                onOpenSeller = { navController.navigate(Routes.SELLER) },
                onOpenAdmin = { navController.navigate(Routes.ADMIN) }
            )
        }
        composable(Routes.ORDERS) {
            OrderTrackingScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.SEARCH) {
            SearchScreen(
                onBack = { navController.popBackStack() },
                onOpenProduct = { pid -> navController.navigate(Routes.product(pid)) }
            )
        }
        composable(Routes.SELLER) {
            SellerDashboardScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.ADMIN) {
            AdminDashboardScreen(onBack = { navController.popBackStack() })
        }
    }
}
