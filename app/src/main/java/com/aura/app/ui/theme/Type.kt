package com.aura.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * AURA Typography
 * Stable CI/CD compatible version
 * No GoogleFont dependency issues
 */

object AuraFont {
    val Display = FontFamily.Serif
    val Serif = FontFamily.Serif
    val Sans = FontFamily.SansSerif
}

val AuraTypography = Typography(

    // =========================
    // DISPLAY
    // =========================

    displayLarge = TextStyle(
        fontFamily = AuraFont.Display,
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = 0.18.em,
        lineHeight = 100.sp
    ),

    displayMedium = TextStyle(
        fontFamily = AuraFont.Display,
        fontWeight = FontWeight.Light,
        fontSize = 64.sp,
        letterSpacing = 0.12.em,
        lineHeight = 70.sp
    ),

    displaySmall = TextStyle(
        fontFamily = AuraFont.Display,
        fontWeight = FontWeight.Normal,
        fontSize = 44.sp,
        letterSpacing = 0.08.em,
        lineHeight = 50.sp
    ),

    // =========================
    // HEADLINES
    // =========================

    headlineLarge = TextStyle(
        fontFamily = AuraFont.Serif,
        fontWeight = FontWeight.Light,
        fontSize = 40.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.01.em
    ),

    headlineMedium = TextStyle(
        fontFamily = AuraFont.Serif,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.01.em
    ),

    headlineSmall = TextStyle(
        fontFamily = AuraFont.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.01.em
    ),

    // =========================
    // TITLES
    // =========================

    titleLarge = TextStyle(
        fontFamily = AuraFont.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.02.em
    ),

    titleMedium = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.04.em
    ),

    titleSmall = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.22.em
    ),

    // =========================
    // BODY
    // =========================

    bodyLarge = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.02.em
    ),

    bodyMedium = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Light,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.02.em
    ),

    bodySmall = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.03.em
    ),

    // =========================
    // LABELS
    // =========================

    labelLarge = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
        letterSpacing = 0.34.em,
        lineHeight = 14.sp,
        textAlign = TextAlign.Center
    ),

    labelMedium = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 0.32.em,
        lineHeight = 14.sp
    ),

    labelSmall = TextStyle(
        fontFamily = AuraFont.Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 9.sp,
        letterSpacing = 0.40.em,
        lineHeight = 12.sp
    )
)
