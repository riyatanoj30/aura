package com.aura.app.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * AURA color palette.
 *
 * Old-money restraint. Gold is an *accent*, never a fill — used for hairlines,
 * micro-text, and a single mark per surface. The black is warm (not pure #000);
 * the white is ivory (not pure #FFF). The difference between fast-fashion and
 * a luxury maison lives in those few percentage points of warmth.
 */
object AuraColors {
    val Ink         = Color(0xFF0B0908)   // matte black, warm
    val Smoke       = Color(0xFF1A1614)   // raised black surfaces
    val Espresso    = Color(0xFF2B1810)   // deep brown
    val Bronze      = Color(0xFF8B6F47)   // metallic bronze
    val Gold        = Color(0xFFB8945F)   // dulled gold
    val Champagne   = Color(0xFFC9A961)   // champagne — primary accent
    val Beige       = Color(0xFFD4C5B0)   // warm beige
    val Bone        = Color(0xFFECE5D8)   // soft bone (cards)
    val Ivory       = Color(0xFFF5F1EA)   // warm white — primary text on dark
    val Paper       = Color(0xFFFAF7F0)   // paper white (light surfaces)

    // Hairlines — used everywhere instead of solid borders
    val HairLight   = Color(0x24F5F1EA)   // on dark
    val HairInk     = Color(0x1F0B0908)   // on light
}
