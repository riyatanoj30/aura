package com.aura.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraStroke

/**
 * The AURA button. Hairline border. Never filled by default. Wide
 * letter-spacing. A thin arrow that lengthens on hover/press.
 *
 * @param variant primary uses champagne gold border; ghost uses bone.
 * @param fillOnInteract if true, surface fills on hover/press (used sparingly).
 */
@Composable
fun AuraButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AuraButtonVariant = AuraButtonVariant.Ghost,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val hovered by interactionSource.collectIsHoveredAsState()
    val active = pressed || hovered

    val borderColor = when (variant) {
        AuraButtonVariant.Primary -> AuraColors.Champagne
        AuraButtonVariant.Ghost   -> AuraColors.HairLight
        AuraButtonVariant.OnLight -> AuraColors.Ink
    }
    val textColor = when (variant) {
        AuraButtonVariant.Primary -> if (active) AuraColors.Ink else AuraColors.Champagne
        AuraButtonVariant.Ghost   -> if (active) AuraColors.Ink else AuraColors.Ivory
        AuraButtonVariant.OnLight -> if (active) AuraColors.Ivory else AuraColors.Ink
    }
    val fillColor = when (variant) {
        AuraButtonVariant.Primary -> AuraColors.Champagne
        AuraButtonVariant.Ghost   -> AuraColors.Ivory
        AuraButtonVariant.OnLight -> AuraColors.Ink
    }

    val fillAlpha by animateFloatAsState(
        targetValue = if (active && enabled) 1f else 0f,
        label = "fillAlpha"
    )

    Box(
        modifier = modifier
            .border(BorderStroke(AuraStroke.rule, borderColor))
            .background(fillColor.copy(alpha = fillAlpha))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            )
            .padding(horizontal = 32.dp, vertical = 18.dp)
            .alpha(if (enabled) 1f else 0.5f),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = label.uppercase(),
                color = textColor,
                style = MaterialTheme.typography.labelLarge
            )
            HairlineArrow(color = textColor, lengthDp = if (active) 28 else 18)
        }
    }
}

enum class AuraButtonVariant { Primary, Ghost, OnLight }

/** Thin horizontal line ending in a right-tip arrowhead. */
@Composable
fun HairlineArrow(color: Color, lengthDp: Int = 18) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .width(lengthDp.dp)
                .height(1.dp)
                .background(color)
        )
        // 6dp triangular tip drawn as two rotated lines using offset boxes
        Box(
            Modifier
                .padding(start = (-1).dp)
                .size(6.dp)
        ) {
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .width(6.dp)
                    .height(1.dp)
                    .background(color)
            )
            Box(
                Modifier
                    .align(Alignment.CenterEnd)
                    .width(1.dp)
                    .height(6.dp)
                    .background(color)
            )
        }
    }
}
