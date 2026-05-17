package com.aura.app.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aura.app.data.repository.ProductRepository
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.components.ProductCard
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing
import com.aura.app.ui.theme.AuraStroke

@Composable
fun SearchScreen(
    onBack: () -> Unit,
    onOpenProduct: (String) -> Unit
) {
    var query by remember { mutableStateOf("") }
    val results = remember(query) {
        if (query.isBlank()) emptyList()
        else ProductRepository.all().filter {
            it.name.contains(query, ignoreCase = true) ||
            it.subcategory.contains(query, ignoreCase = true) ||
            it.fabric.contains(query, ignoreCase = true)
        }
    }

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        Column(Modifier.fillMaxSize()) {
            // Search bar
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AuraSpacing.edge, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.Search, null,
                    tint = AuraColors.Champagne,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(14.dp))
                Box(Modifier.weight(1f)) {
                    if (query.isEmpty()) {
                        Text(
                            text = "Search the house  ·  pieces, fabrics, ateliers",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AuraColors.Ivory.copy(alpha = 0.4f)
                        )
                    }
                    BasicTextField(
                        value = query,
                        onValueChange = { query = it },
                        singleLine = true,
                        textStyle = TextStyle(
                            color = AuraColors.Ivory,
                            fontSize = 14.sp
                        ),
                        cursorBrush = SolidColor(AuraColors.Champagne),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                if (query.isNotEmpty()) {
                    Spacer(Modifier.width(8.dp))
                    Icon(
                        Icons.Outlined.Close, "Clear",
                        tint = AuraColors.Ivory.copy(alpha = 0.6f),
                        modifier = Modifier
                            .size(18.dp)
                            .clickable { query = "" }
                    )
                }
                Spacer(Modifier.width(14.dp))
                Text(
                    text = "CANCEL",
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Champagne,
                    modifier = Modifier.clickable(onClick = onBack)
                )
            }
            Hairline(color = AuraColors.HairLight)

            if (query.isBlank()) {
                // Suggestion state
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = AuraSpacing.edge, vertical = 40.dp)
                ) {
                    Eyebrow("EXPLORE")
                    Spacer(Modifier.height(20.dp))
                    listOf(
                        "Camel Overcoat",
                        "Mechanical Watches",
                        "Italian Leather",
                        "Cashmere Knitwear",
                        "Evening Silks"
                    ).forEach {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.headlineSmall,
                            color = AuraColors.Bone,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { query = it }
                                .padding(vertical = 12.dp)
                        )
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(AuraColors.HairLight)
                        )
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 80.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    item(span = { GridItemSpan(2) }) {
                        Text(
                            text = "${results.size} pieces matched.".uppercase(),
                            style = MaterialTheme.typography.labelMedium,
                            color = AuraColors.Champagne,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 12.dp)
                        )
                    }
                    items(results, key = { it.id }) { p ->
                        ProductCard(product = p, onClick = { onOpenProduct(p.id) })
                    }
                }
            }
        }
    }
}
