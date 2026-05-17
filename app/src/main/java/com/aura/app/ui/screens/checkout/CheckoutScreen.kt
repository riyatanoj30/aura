package com.aura.app.ui.screens.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aura.app.data.repository.CartRepository
import com.aura.app.ui.components.AuraButton
import com.aura.app.ui.components.AuraButtonVariant
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing
import com.aura.app.ui.theme.AuraStroke

@Composable
fun CheckoutScreen(
    onBack: () -> Unit,
    onPlaced: () -> Unit
) {
    val items by CartRepository.items.collectAsState()
    val subtotalCents = items.sumOf { it.lineTotalCents }
    val total = "$ %,d".format(subtotalCents / 100)

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var card by remember { mutableStateOf("") }

    val scroll = rememberScrollState()

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        Column(Modifier.fillMaxSize().verticalScroll(scroll)) {
            // ─── Header ───
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
                Eyebrow("THE SECURE CHECKOUT")
                Spacer(Modifier.height(14.dp))
                Text(
                    "Checkout",
                    style = MaterialTheme.typography.displayMedium,
                    color = AuraColors.Ivory
                )
            }
            Hairline(color = AuraColors.HairLight)

            // ─── Contact ───
            FormSection("01  ·  CONTACT") {
                AuraField("Full Name", name) { name = it }
                AuraField("Email Address", email) { email = it }
            }

            // ─── Shipping ───
            FormSection("02  ·  SHIPPING") {
                AuraField("Shipping Address", address) { address = it }
                Spacer(Modifier.height(8.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "WHITE-GLOVE DELIVERY",
                        style = MaterialTheme.typography.labelSmall,
                        color = AuraColors.Champagne
                    )
                    Text(
                        "COMPLIMENTARY",
                        style = MaterialTheme.typography.labelSmall,
                        color = AuraColors.Bone
                    )
                }
            }

            // ─── Payment ───
            FormSection("03  ·  PAYMENT") {
                AuraField("Card Number", card) { card = it }
                Spacer(Modifier.height(8.dp))
                Text(
                    "PROTECTED BY 256-BIT ENCRYPTION  ·  NEVER STORED ON OUR SERVERS",
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Ivory.copy(alpha = 0.4f)
                )
            }

            // ─── Order summary ───
            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 32.dp)) {
                Eyebrow("ORDER SUMMARY")
                Spacer(Modifier.height(20.dp))
                items.forEach {
                    Row(
                        Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${it.product.name}  ×${it.quantity}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AuraColors.Bone,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = "$ %,d".format(it.lineTotalCents / 100),
                            style = MaterialTheme.typography.bodyMedium,
                            color = AuraColors.Bone
                        )
                    }
                }
                Spacer(Modifier.height(16.dp))
                Hairline(color = AuraColors.HairLight)
                Spacer(Modifier.height(16.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        "TOTAL",
                        style = MaterialTheme.typography.labelMedium,
                        color = AuraColors.Ivory.copy(alpha = 0.6f)
                    )
                    Text(
                        total,
                        style = MaterialTheme.typography.headlineMedium,
                        color = AuraColors.Champagne
                    )
                }
            }

            Spacer(Modifier.height(8.dp))
            Column(Modifier.padding(horizontal = AuraSpacing.edge)) {
                AuraButton(
                    label = "Place Order",
                    onClick = {
                        CartRepository.clear()
                        onPlaced()
                    },
                    variant = AuraButtonVariant.Primary,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(Modifier.height(48.dp))
        }
    }
}

@Composable
private fun FormSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 28.dp)) {
        Eyebrow(title)
        Spacer(Modifier.height(20.dp))
        content()
    }
    Hairline(color = AuraColors.HairLight)
}

@Composable
private fun AuraField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(Modifier.padding(bottom = 22.dp)) {
        Text(
            text = label.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.55f)
        )
        Spacer(Modifier.height(10.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(
                color = AuraColors.Ivory,
                fontSize = 16.sp
            ),
            cursorBrush = SolidColor(AuraColors.Champagne),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(AuraStroke.rule)
                .background(AuraColors.HairLight)
        )
    }
}
