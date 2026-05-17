package com.aura.app

import android.app.Application

class AuraApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Singletons (CartRepository, WishlistRepository) are object-based,
        // so they initialise on first reference — no explicit DI bootstrap.
    }
}
