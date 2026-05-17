package com.aura.app.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aura.app.ui.theme.AuraColors
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * The splash. AURA reveals letter by letter, the gold rule grows beneath,
 * then the screen exits to the home page. About 2.4 seconds total.
 */
@Composable
fun SplashScreen(onFinished: () -> Unit) {
    val letters = listOf("A", "U", "R", "A")
    val anims = remember { List(letters.size) { Animatable(0f) } }
    val ruleScale = remember { Animatable(0f) }
    val taglineAlpha = remember { Animatable(0f) }
    val rootAlpha = remember { Animatable(1f) }

    LaunchedEffect(Unit) {
        // Reveal each letter in sequence
        letters.forEachIndexed { i, _ ->
            launch {
                delay(160L * i)
                anims[i].animateTo(1f, tween(700, easing = LinearOutSlowInEasing))
            }
        }
        // Rule grows after the last letter
        launch {
            delay(900)
            ruleScale.animateTo(1f, tween(700, easing = LinearOutSlowInEasing))
        }
        // Tagline fades in
        launch {
            delay(1300)
            taglineAlpha.animateTo(1f, tween(700))
        }
        // Hold, then fade and exit
        delay(2200)
        rootAlpha.animateTo(0f, tween(450))
        onFinished()
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(AuraColors.Ink)
            .alpha(rootAlpha.value),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Letters
            Row {
                letters.forEachIndexed { i, letter ->
                    Text(
                        text = letter,
                        style = MaterialTheme.typography.displayLarge.copy(fontSize = 84.sp),
                        color = AuraColors.Ivory,
                        modifier = Modifier
                            .alpha(anims[i].value)
                            .graphicsLayer { translationY = (1f - anims[i].value) * 40f }
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            // Champagne rule
            Box(
                Modifier
                    .width(120.dp)
                    .height(1.dp)
                    .scale(scaleX = ruleScale.value, scaleY = 1f)
                    .background(AuraColors.Champagne)
            )
            Spacer(Modifier.height(20.dp))
            // Tagline
            Text(
                text = "STYLE THAT SPEAKS",
                style = MaterialTheme.typography.labelMedium,
                color = AuraColors.Champagne,
                modifier = Modifier.alpha(taglineAlpha.value)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "EST. 1920",
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Ivory.copy(alpha = 0.4f),
                modifier = Modifier.alpha(taglineAlpha.value)
            )
        }
    }
}
