package com.aura.app.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing

@Composable
fun ProfileScreen(
    onBack: () -> Unit,
    onOpenOrders: () -> Unit,
    onOpenWishlist: () -> Unit,
    onOpenSeller: () -> Unit,
    onOpenAdmin: () -> Unit
) {
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

            // ── Greeting card ──
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(AuraColors.Smoke)
                    .padding(horizontal = AuraSpacing.edge, vertical = 36.dp)
            ) {
                Eyebrow("HOUSE CLIENTELE  ·  TIER  ·  AURUM")
                Spacer(Modifier.height(14.dp))
                Text(
                    text = "Bonjour, Madame.",
                    style = MaterialTheme.typography.displayMedium.copy(fontStyle = FontStyle.Italic),
                    color = AuraColors.Ivory
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Your private salon access has been active since March 2024.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = AuraColors.Ivory.copy(alpha = 0.6f)
                )
            }

            // ── Buyer sections ──
            ProfileSection("YOUR ACTIVITY") {
                ProfileRow("My Orders", "Track & manage", onClick = onOpenOrders)
                ProfileRow("Wishlist", "Pieces saved aside", onClick = onOpenWishlist)
                ProfileRow("Personal Appointments", "Stylist · Tailor · Restoration", onClick = {})
                ProfileRow("Saved Addresses", "Three on file", onClick = {})
                ProfileRow("Payment Methods", "Two cards", onClick = {}, isLast = true)
            }

            ProfileSection("PREFERENCES") {
                ProfileRow("Size Profile", "Tailored measurements", onClick = {})
                ProfileRow("Communications", "Salon notes only", onClick = {})
                ProfileRow("Language", "English", onClick = {})
                ProfileRow("Currency", "USD ·  $", onClick = {}, isLast = true)
            }

            ProfileSection("PROFESSIONAL ACCESS") {
                ProfileRow("Seller Studio", "Manage your boutique", onClick = onOpenSeller)
                ProfileRow("House Administration", "Restricted access", onClick = onOpenAdmin, isLast = true)
            }

            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 48.dp)) {
                Text(
                    text = "SIGN OUT",
                    style = MaterialTheme.typography.labelMedium,
                    color = AuraColors.Ivory.copy(alpha = 0.55f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                        .clickable {},
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "AURA  ·  MEMBER SINCE 2024",
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Ivory.copy(alpha = 0.35f),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun ProfileSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(Modifier.padding(top = 32.dp)) {
        Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 12.dp)) {
            Eyebrow(title)
        }
        content()
    }
}

@Composable
private fun ProfileRow(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    isLast: Boolean = false
) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(horizontal = AuraSpacing.edge, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = AuraColors.Ivory
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = subtitle.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Ivory.copy(alpha = 0.5f)
                )
            }
            Icon(
                Icons.Outlined.ChevronRight, null,
                tint = AuraColors.Champagne.copy(alpha = 0.7f),
                modifier = Modifier.size(18.dp)
            )
        }
        if (!isLast) Hairline(color = AuraColors.HairLight)
    }
}
