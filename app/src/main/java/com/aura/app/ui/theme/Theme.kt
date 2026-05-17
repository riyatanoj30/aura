package com.aura.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * The AURA app intentionally runs in a single dark "maison" theme.
 * No light mode toggle — luxury houses commit. (Light surfaces appear
 * within the design as sections, not as system-level themes.)
 */

private val AuraColorScheme = darkColorScheme(
    primary           = AuraColors.Champagne,
    onPrimary         = AuraColors.Ink,
    primaryContainer  = AuraColors.Bronze,
    onPrimaryContainer = AuraColors.Ivory,

    secondary         = AuraColors.Bronze,
    onSecondary       = AuraColors.Ivory,
    secondaryContainer = AuraColors.Espresso,
    onSecondaryContainer = AuraColors.Bone,

    tertiary          = AuraColors.Gold,
    onTertiary        = AuraColors.Ink,

    background        = AuraColors.Ink,
    onBackground      = AuraColors.Ivory,
    surface           = AuraColors.Ink,
    onSurface         = AuraColors.Ivory,
    surfaceVariant    = AuraColors.Smoke,
    onSurfaceVariant  = AuraColors.Bone,

    outline           = AuraColors.HairLight,
    outlineVariant    = AuraColors.HairLight,

    error             = AuraColors.Bronze,
    onError           = AuraColors.Ivory
)

@Composable
fun AuraTheme(
    @Suppress("UNUSED_PARAMETER") darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = AuraColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = AuraColors.Ink.toArgb()
            window.navigationBarColor = AuraColors.Ink.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AuraTypography,
        content = content
    )
}
