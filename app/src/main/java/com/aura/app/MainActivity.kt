package com.aura.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.aura.app.ui.navigation.AuraNavHost
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // System splash hands off to our Compose splash for the letter-reveal.
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Edge-to-edge so the hero photography goes under the status bar.
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(AuraColors.Ink.toArgb()),
            navigationBarStyle = SystemBarStyle.dark(AuraColors.Ink.toArgb())
        )

        setContent {
            AuraTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AuraColors.Ink),
                    color = Color.Transparent
                ) {
                    val navController = rememberNavController()
                    AuraNavHost(navController = navController)
                }
            }
        }
    }
}
