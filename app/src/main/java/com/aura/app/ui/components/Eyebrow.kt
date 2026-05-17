package com.aura.app.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aura.app.ui.theme.AuraColors

/**
 * Tiny caps line — the universal opener of an AURA section. The hallmark
 * detail is the wide letter-spacing already baked into labelMedium.
 */
@Composable
fun Eyebrow(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AuraColors.Champagne
) {
    Text(
        text = text.uppercase(),
        color = color,
        style = MaterialTheme.typography.labelMedium,
        modifier = modifier
    )
}

/** Thin horizontal hairline — used to separate sections. */
@Composable
fun Hairline(
    modifier: Modifier = Modifier,
    color: Color = AuraColors.HairLight
) {
    Box(
        modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color)
    )
}

/** Short centred gold line — used under headings as an ornamental finial. */
@Composable
fun OrnamentalRule(
    modifier: Modifier = Modifier,
    width: Int = 38,
    color: Color = AuraColors.Champagne
) {
    Box(modifier, contentAlignment = Alignment.Center) {
        Box(
            Modifier
                .width(width.dp)
                .height(1.dp)
                .background(color)
        )
    }
}
