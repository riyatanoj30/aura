package com.aura.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.aura.app.R

/**
 * AURA typography
 */

private val fontProvider = Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val Italiana = FontFamily(
    Font(
        googleFont = GoogleFont("Italiana"),
        fontProvider = fontProvider,
        weight = FontWeight.Normal
    )
)

private val Cormorant = FontFamily(
    Font(
        googleFont = GoogleFont("Cormorant Garamond"),
        fontProvider = fontProvider,
        weight = FontWeight.Light
    ),
    Font(
        googleFont = GoogleFont("Cormorant Garamond"),
        fontProvider = fontProvider,
        weight = FontWeight.Normal
    ),
    Font(
        googleFont = GoogleFont("Cormorant Garamond"),
        fontProvider = fontProvider,
        weight = FontWeight.Medium
    ),
    Font(
        googleFont = GoogleFont("Cormorant Garamond"),
        fontProvider = fontProvider,
        weight = FontWeight.SemiBold
    )
)

private val Jost = FontFamily(
    Font(
        googleFont = GoogleFont("Jost"),
        fontProvider = fontProvider,
        weight = FontWeight.Thin
    ),
    Font(
        googleFont = GoogleFont("Jost"),
        fontProvider = fontProvider,
        weight = FontWeight.Light
    ),
    Font(
        googleFont = GoogleFont("Jost"),
        fontProvider = fontProvider,
        weight = FontWeight.Normal
    ),
    Font(
        googleFont = GoogleFont("Jost"),
        fontProvider = fontProvider,
        weight = FontWeight.Medium
    )
)

object AuraFont {
    val Display = Italiana
    val Serif = Cormorant
    val Sans = Jost
}

val AuraTypography = Typography(

    displayLarge = TextStyle(
        fontFamily = Italiana,
        fontWeight = FontWeight.Normal,
        fontSize = 96.sp,
        letterSpacing = 0.18.em,
        lineHeight = 100.sp
    ),

    displayMedium = TextStyle(
        fontFamily = Italiana,
        fontWeight = FontWeight.Normal,
        fontSize = 64.sp,
        letterSpacing = 0.12.em,
        lineHeight = 70.sp
    ),

    displaySmall = TextStyle(
        fontFamily = Italiana,
        fontWeight = FontWeight.Normal,
        fontSize = 44.sp,
        letterSpacing = 0.08.em,
        lineHeight = 50.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.Light,
        fontSize = 40.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.01.em
    ),

    headlineMedium = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.01.em
    ),

    headlineSmall = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.01.em
    ),

    titleLarge = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.02.em
    ),

    titleMedium = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.04.em
    ),

    titleSmall = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        letterSpacing = 0.22.em,
        lineHeight = 16.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.02.em
    ),

    bodyMedium = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Light,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.02.em
    ),

    bodySmall = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.03.em
    ),

    labelLarge = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
        letterSpacing = 0.34.em,
        lineHeight = 14.sp,
        textAlign = TextAlign.Center
    ),

    labelMedium = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 0.32.em,
        lineHeight = 14.sp
    ),

    labelSmall = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 9.sp,
        letterSpacing = 0.40.em,
        lineHeight = 12.sp
    )
)
