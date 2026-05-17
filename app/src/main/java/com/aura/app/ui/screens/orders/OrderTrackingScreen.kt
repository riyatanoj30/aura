package com.aura.app.ui.screens.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.aura.app.ui.components.AuraButton
import com.aura.app.ui.components.AuraButtonVariant
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.components.OrnamentalRule
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing

@Composable
fun OrderTrackingScreen(onBack: () -> Unit) {
    val scroll = rememberScrollState()

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        Column(Modifier.fillMaxSize().verticalScroll(scroll)) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AuraSpacing.edge, vertical = AuraSpacing.md),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.ArrowBack, "Back",
                    tint = AuraColors.Ivory,
                    modifier = Modifier.size(22.dp).clickable(onClick = onBack)
                )
            }

            // ── Confirmation banner ──
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(AuraColors.Smoke)
                    .padding(horizontal = AuraSpacing.edge, vertical = 56.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Eyebrow("YOUR ORDER IS WITH US")
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Thank you, sincerely.",
                    style = MaterialTheme.typography.headlineLarge.copy(fontStyle = FontStyle.Italic),
                    color = AuraColors.Ivory
                )
                Spacer(Modifier.height(20.dp))
                OrnamentalRule(width = 48, color = AuraColors.Champagne)
                Spacer(Modifier.height(20.dp))
                Text(
                    "ORDER N° AUR-24-1041",
                    style = MaterialTheme.typography.labelMedium,
                    color = AuraColors.Champagne
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Estimated delivery — 3 to 5 business days.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = AuraColors.Ivory.copy(alpha = 0.6f)
                )
            }

            Spacer(Modifier.height(40.dp))

            // ── Timeline ──
            Column(Modifier.padding(horizontal = AuraSpacing.edge)) {
                Eyebrow("THE PROGRESS")
                Spacer(Modifier.height(28.dp))
                StatusStep("Order Received", "Today  ·  9:42 AM", state = StepState.DONE)
                StatusStep("With Our Atelier", "Quality control & gift-wrapping", state = StepState.ACTIVE)
                StatusStep("In Transit", "Pending dispatch", state = StepState.PENDING)
                StatusStep("Delivered", "—", state = StepState.PENDING, isLast = true)
            }

            Spacer(Modifier.height(48.dp))
            Hairline(color = AuraColors.HairLight)

            // ── Order details ──
            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 32.dp)) {
                Eyebrow("DELIVERY ADDRESS")
                Spacer(Modifier.height(14.dp))
                Text("Madame Marguerite Aubert", style = MaterialTheme.typography.titleLarge, color = AuraColors.Ivory)
                Spacer(Modifier.height(4.dp))
                Text(
                    "18 Rue du Faubourg Saint-Honoré\n75008 Paris, France",
                    style = MaterialTheme.typography.bodyMedium,
                    color = AuraColors.Ivory.copy(alpha = 0.7f)
                )
            }

            Hairline(color = AuraColors.HairLight)

            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 32.dp)) {
                Eyebrow("YOUR HOUSE CONCIERGE")
                Spacer(Modifier.height(14.dp))
                Text(
                    "For any question — large or small — your dedicated concierge is reachable, day or night.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = AuraColors.Bone
                )
                Spacer(Modifier.height(20.dp))
                AuraButton(
                    label = "Contact Concierge",
                    onClick = {},
                    variant = AuraButtonVariant.Primary
                )
            }

            Spacer(Modifier.height(60.dp))
        }
    }
}

private enum class StepState { DONE, ACTIVE, PENDING }

@Composable
private fun StatusStep(
    title: String,
    subtitle: String,
    state: StepState,
    isLast: Boolean = false
) {
    Row(verticalAlignment = Alignment.Top) {
        // Marker column
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(
                        when (state) {
                            StepState.DONE -> AuraColors.Champagne
                            StepState.ACTIVE -> AuraColors.Champagne.copy(alpha = 0.25f)
                            StepState.PENDING -> AuraColors.Smoke
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (state == StepState.DONE) {
                    Icon(
                        Icons.Outlined.Check, null,
                        tint = AuraColors.Ink,
                        modifier = Modifier.size(14.dp)
                    )
                } else if (state == StepState.ACTIVE) {
                    Box(
                        Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(AuraColors.Champagne)
                    )
                }
            }
            if (!isLast) {
                Box(
                    Modifier
                        .padding(top = 4.dp)
                        .width(1.dp)
                        .height(56.dp)
                        .background(AuraColors.HairLight)
                )
            }
        }
        Spacer(Modifier.width(20.dp))
        Column(Modifier.padding(bottom = if (isLast) 0.dp else 28.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = if (state == StepState.PENDING)
                    AuraColors.Ivory.copy(alpha = 0.4f)
                else
                    AuraColors.Ivory
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = subtitle.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = if (state == StepState.DONE)
                    AuraColors.Champagne
                else
                    AuraColors.Ivory.copy(alpha = 0.45f)
            )
        }
    }
}
