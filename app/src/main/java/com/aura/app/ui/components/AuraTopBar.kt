package com.aura.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aura.app.data.repository.CartRepository
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing
import com.aura.app.ui.theme.AuraStroke

/**
 * The maison's top bar: a wordmark in the centre, utilities on either side,
 * sitting on a near-transparent surface so the hero photography reads beneath it.
 */
@Composable
fun AuraTopBar(
    onMenu: () -> Unit = {},
    onSearch: () -> Unit = {},
    onBag: () -> Unit = {},
    transparent: Boolean = false,
    modifier: Modifier = Modifier
) {
    val cartItems by CartRepository.items.collectAsState()
    val bagCount = cartItems.sumOf { it.quantity }

    Box(
        modifier
            .fillMaxWidth()
            .background(if (transparent) AuraColors.Ink.copy(alpha = 0.55f) else AuraColors.Ink)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge, vertical = AuraSpacing.md),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Outlined.Menu,
                contentDescription = "Menu",
                tint = AuraColors.Ivory,
                modifier = Modifier
                    .size(22.dp)
                    .clickable(onClick = onMenu)
            )
            Box(
                Modifier
                    .weight(1f)
                    .padding(horizontal = AuraSpacing.sm),
                contentAlignment = Alignment.Center
            ) {
                AuraWordmark(small = true)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = "Search",
                    tint = AuraColors.Ivory,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable(onClick = onSearch)
                )
                Box(Modifier.clickable(onClick = onBag)) {
                    Icon(
                        Icons.Outlined.ShoppingBag,
                        contentDescription = "Bag",
                        tint = AuraColors.Ivory,
                        modifier = Modifier.size(22.dp)
                    )
                    if (bagCount > 0) {
                        Box(
                            Modifier
                                .align(Alignment.TopEnd)
                                .offset(x = 6.dp, y = (-4).dp)
                                .clip(CircleShape)
                                .background(AuraColors.Champagne)
                                .padding(horizontal = 5.dp, vertical = 1.dp)
                        ) {
                            Text(
                                text = bagCount.toString(),
                                style = MaterialTheme.typography.labelSmall.copy(
                                    letterSpacing = 0.sp
                                ),
                                color = AuraColors.Ink
                            )
                        }
                    }
                }
            }
        }
        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(AuraStroke.rule)
                .background(AuraColors.HairLight)
        )
    }
}

/** AURA wordmark — Italiana, wide-spaced, with a hairline rule beneath. */
@Composable
fun AuraWordmark(
    small: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "AURA",
            style = MaterialTheme.typography.displaySmall.copy(
                fontSize = if (small) 18.sp else 44.sp
            ),
            color = AuraColors.Ivory
        )
        Spacer(Modifier.height(if (small) 2.dp else 4.dp))
        Box(
            Modifier
                .width(if (small) 22.dp else 56.dp)
                .height(1.dp)
                .background(AuraColors.Champagne)
        )
        if (!small) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = "EST. 1920",
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Champagne
            )
        }
    }
}
