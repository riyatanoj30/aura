package com.aura.app.ui.screens.seller

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aura.app.data.repository.ProductRepository
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing
import com.aura.app.ui.theme.AuraStroke

@Composable
fun SellerDashboardScreen(onBack: () -> Unit) {
    val inventory = ProductRepository.all()
    val totalCents = inventory.sumOf { it.priceCents.toLong() * it.inStock }

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        LazyColumn(
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            // Header
            item {
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
                Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 24.dp)) {
                    Eyebrow("SELLER STUDIO  ·  AURA BOUTIQUE")
                    Spacer(Modifier.height(14.dp))
                    Text(
                        text = "Your House.",
                        style = MaterialTheme.typography.displayMedium.copy(fontStyle = FontStyle.Italic),
                        color = AuraColors.Ivory
                    )
                }
                Hairline(color = AuraColors.HairLight)
            }

            // KPI strip
            item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 28.dp, horizontal = AuraSpacing.edge),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StatCell("$ %,d".format(totalCents / 100), "INVENTORY VALUE")
                    StatCell(inventory.size.toString(), "PIECES LISTED")
                    StatCell("23", "ORDERS  ·  30D")
                    StatCell("4.9", "CLIENT RATING")
                }
                Hairline(color = AuraColors.HairLight)
            }

            // Actions
            item {
                Column(Modifier.padding(top = 28.dp)) {
                    Column(Modifier.padding(horizontal = AuraSpacing.edge)) {
                        Eyebrow("ACTIONS")
                    }
                    Spacer(Modifier.height(8.dp))
                    ActionCard(
                        title = "Upload New Piece",
                        subtitle = "PHOTOGRAPHY  ·  DETAILS  ·  PRICING",
                        primary = true
                    )
                    ActionCard(
                        title = "Inventory & Stock",
                        subtitle = "${inventory.size} ACTIVE"
                    )
                    ActionCard(
                        title = "Open Orders",
                        subtitle = "7 AWAITING DISPATCH"
                    )
                    ActionCard(
                        title = "Analytics",
                        subtitle = "TRAFFIC  ·  CONVERSION  ·  RETURNS"
                    )
                }
            }

            // Inventory list
            item {
                Column(
                    Modifier.padding(horizontal = AuraSpacing.edge, top = 32.dp, bottom = 12.dp)
                ) {
                    Eyebrow("INVENTORY  ·  RECENT")
                }
                Hairline(color = AuraColors.HairLight)
            }
            items(inventory.take(8), key = { it.id }) { p ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AuraSpacing.edge, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        Modifier
                            .size(64.dp)
                            .background(AuraColors.Smoke)
                    ) {
                        AsyncImage(
                            model = p.images.firstOrNull(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(Modifier.width(16.dp))
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = p.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = AuraColors.Ivory
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = "${p.inStock} in stock  ·  ${p.priceFormatted}",
                            style = MaterialTheme.typography.labelSmall,
                            color = AuraColors.Champagne
                        )
                    }
                    val state = when {
                        p.inStock == 0     -> "OUT" to AuraColors.Bronze
                        p.inStock < 3      -> "LOW" to AuraColors.Champagne
                        else               -> "OK"  to AuraColors.Ivory.copy(alpha = 0.55f)
                    }
                    Text(
                        text = state.first,
                        style = MaterialTheme.typography.labelSmall,
                        color = state.second
                    )
                }
                Hairline(color = AuraColors.HairLight)
            }
        }
    }
}

@Composable
private fun StatCell(value: String, label: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = AuraColors.Champagne
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.55f)
        )
    }
}

@Composable
private fun ActionCard(title: String, subtitle: String, primary: Boolean = false) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = AuraSpacing.edge, vertical = 8.dp)
            .border(
                AuraStroke.rule,
                if (primary) AuraColors.Champagne else AuraColors.HairLight
            )
            .padding(horizontal = 20.dp, vertical = 22.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = if (primary) AuraColors.Champagne else AuraColors.Ivory
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Ivory.copy(alpha = 0.5f)
                )
            }
            Icon(
                Icons.Outlined.Add, null,
                tint = if (primary) AuraColors.Champagne else AuraColors.Ivory.copy(alpha = 0.6f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
