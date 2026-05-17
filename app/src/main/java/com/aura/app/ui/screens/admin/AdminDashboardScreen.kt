package com.aura.app.ui.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
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
import com.aura.app.ui.theme.AuraStroke

@Composable
fun AdminDashboardScreen(onBack: () -> Unit) {
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

            // Header
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(AuraColors.Espresso)
                    .padding(horizontal = AuraSpacing.edge, vertical = 40.dp)
            ) {
                Eyebrow("HOUSE ADMINISTRATION  ·  RESTRICTED")
                Spacer(Modifier.height(14.dp))
                Text(
                    text = "The Operations Room.",
                    style = MaterialTheme.typography.displayMedium.copy(fontStyle = FontStyle.Italic),
                    color = AuraColors.Ivory
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Approvals, sellers, and house standards.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = AuraColors.Bone.copy(alpha = 0.75f)
                )
            }

            // ── KPI grid (2×2) ──
            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 24.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    KpiCell(Modifier.weight(1f), "12", "PENDING APPROVALS")
                    KpiCell(Modifier.weight(1f), "$ 1.4M", "GROSS  ·  THIS MONTH")
                }
                Spacer(Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    KpiCell(Modifier.weight(1f), "186", "ACTIVE SELLERS")
                    KpiCell(Modifier.weight(1f), "3.2K", "ACTIVE LISTINGS")
                }
            }

            Hairline(color = AuraColors.HairLight)

            // ── Approvals queue ──
            AdminSection("PENDING  ·  PRODUCT APPROVALS") {
                ApprovalRow("Velvet Smoking Jacket", "Maison Aubert", "$ 4,200")
                ApprovalRow("Mother-of-Pearl Cufflinks", "Atelier Bevan", "$ 980")
                ApprovalRow("Linen Tuxedo", "Maison Vacher", "$ 3,640")
            }

            // ── Seller verification ──
            AdminSection("PENDING  ·  SELLER VERIFICATION") {
                ApprovalRow("Maison Lavigne", "PARIS  ·  ATELIER", "ESTABLISHED 1962")
                ApprovalRow("Bottega Renato", "FLORENCE  ·  LEATHER", "ESTABLISHED 1988")
            }

            // ── Banner / homepage management ──
            AdminSection("HOMEPAGE  ·  BANNER MANAGEMENT") {
                ApprovalRow("Hero Banner", "AUTUMN/WINTER 2026", "LIVE")
                ApprovalRow("Editorial Chapter IV", "CASHMERE & SILENCE", "LIVE")
                ApprovalRow("Spring 2027 Teaser", "DRAFT", "—")
            }

            Spacer(Modifier.height(48.dp))
        }
    }
}

@Composable
private fun KpiCell(modifier: Modifier, value: String, label: String) {
    Column(
        modifier
            .border(AuraStroke.rule, AuraColors.HairLight)
            .padding(20.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = AuraColors.Champagne
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.55f)
        )
    }
}

@Composable
private fun AdminSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(Modifier.padding(top = 32.dp)) {
        Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 12.dp)) {
            Eyebrow(title)
        }
        content()
    }
}

@Composable
private fun ApprovalRow(name: String, who: String, value: String) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge,
                    color = AuraColors.Ivory
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = who.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Ivory.copy(alpha = 0.5f)
                )
            }
            Spacer(Modifier.width(20.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Champagne
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = "REVIEW",
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Champagne,
                modifier = Modifier
                    .border(AuraStroke.hair, AuraColors.Champagne)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }
        Hairline(color = AuraColors.HairLight)
    }
}
