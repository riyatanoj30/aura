package com.aura.app.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aura.app.data.repository.ProductRepository
import com.aura.app.ui.components.*
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing

@Composable
fun HomeScreen(
    onOpenCategory: (String) -> Unit,
    onOpenProduct: (String) -> Unit,
    onOpenCart: () -> Unit,
    onOpenWishlist: () -> Unit,
    onOpenSearch: () -> Unit,
    onOpenProfile: () -> Unit
) {
    val scroll = rememberScrollState()

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scroll)
        ) {
            AnnouncementMarquee()

            // The TopBar sits below the announce strip but above the hero
            AuraTopBar(
                onMenu = onOpenProfile,
                onSearch = onOpenSearch,
                onBag = onOpenCart,
                transparent = false
            )

            HeroSection()
            PhilosophySection()
            CollectionsSection(onOpenCategory)
            EditorialSection()
            NewArrivalsSection(onOpenProduct)
            HeritageSection()
            ClienteleSection()
            FooterSection()
        }
    }
}

/* ─────────────────────────────────── Announcement ─── */

@Composable
private fun AnnouncementMarquee() {
    Box(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Ink)
            .padding(vertical = 11.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "✦  COMPLIMENTARY WORLDWIDE SHIPPING  ·  PRIVATE APPOINTMENTS  ·  AUTUMN/WINTER 2026  ✦",
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.6f)
        )
    }
}

/* ─────────────────────────────────── Hero ─── */

@Composable
private fun HeroSection() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(640.dp)
    ) {
        AsyncImage(
            model = "https://images.unsplash.com/photo-1490481651871-ab68de25d43d?w=2000&q=85",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Cinematic gradient overlay
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to AuraColors.Ink.copy(alpha = 0.45f),
                        0.4f to AuraColors.Ink.copy(alpha = 0.10f),
                        1f to AuraColors.Ink.copy(alpha = 0.90f)
                    )
                )
        )
        // Top-corner meta lines
        Text(
            text = "AUTUMN / WINTER 2026",
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.55f),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = AuraSpacing.edge, top = 28.dp)
        )
        Text(
            text = "CAMPAIGN N° 04  ·  PARIS",
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.55f),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = AuraSpacing.edge, top = 28.dp)
        )
        // Centre content
        Column(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Eyebrow("AURA  ·  THE NEW COLLECTION")
            Spacer(Modifier.height(24.dp))
            Text(
                text = "AURA",
                style = MaterialTheme.typography.displayLarge,
                color = AuraColors.Ivory
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Style that speaks — quietly, eternally.",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontStyle = FontStyle.Italic
                ),
                color = AuraColors.Bone
            )
            Spacer(Modifier.height(28.dp))
            Box(
                Modifier
                    .width(1.dp)
                    .height(40.dp)
                    .background(AuraColors.Champagne)
            )
            Spacer(Modifier.height(28.dp))
            AuraButton(
                label = "Explore the Collection",
                onClick = { },
                variant = AuraButtonVariant.Primary,
                modifier = Modifier.fillMaxWidth(0.78f)
            )
            Spacer(Modifier.height(12.dp))
            AuraButton(
                label = "New Arrivals",
                onClick = { },
                variant = AuraButtonVariant.Ghost,
                modifier = Modifier.fillMaxWidth(0.78f)
            )
        }
    }
}

/* ─────────────────────────────────── Philosophy ─── */

@Composable
private fun PhilosophySection() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Ivory)
            .padding(horizontal = AuraSpacing.edge, vertical = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Eyebrow("THE HOUSE  ·  A NOTE", color = AuraColors.Bronze)
        Spacer(Modifier.height(28.dp))
        Text(
            text = "In an age of noise, we believe in the eloquence of restraint. " +
                    "Every thread, every seam, every silhouette is composed to outlast a season — " +
                    "and quietly, to outlast a lifetime.",
            style = MaterialTheme.typography.headlineMedium,
            color = AuraColors.Ink,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(40.dp))
        OrnamentalRule(color = AuraColors.Bronze, width = 50)
        Spacer(Modifier.height(12.dp))
        Text(
            text = "A. Laurent",
            style = MaterialTheme.typography.titleLarge.copy(fontStyle = FontStyle.Italic),
            color = AuraColors.Espresso
        )
        Text(
            text = "CREATIVE DIRECTOR",
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Bronze
        )
    }
}

/* ─────────────────────────────────── Collections ─── */

@Composable
private fun CollectionsSection(onOpenCategory: (String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Ink)
            .padding(top = 80.dp, bottom = 80.dp)
    ) {
        Column(Modifier.padding(horizontal = AuraSpacing.edge)) {
            Text(
                text = "The Collection",
                style = MaterialTheme.typography.displaySmall,
                color = AuraColors.Ivory
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Six houses under one name. Each cultivated with the same patient hand — " +
                        "from the cutting room in Paris to the leather workshops of Florence.",
                style = MaterialTheme.typography.bodyMedium,
                color = AuraColors.Ivory.copy(alpha = 0.6f)
            )
        }
        Spacer(Modifier.height(40.dp))
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            ProductRepository.categories().forEach { cat ->
                CategoryCard(
                    category = cat,
                    onClick = { onOpenCategory(cat.id) }
                )
            }
        }
    }
}

/* ─────────────────────────────────── Editorial ─── */

@Composable
private fun EditorialSection() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Bone)
    ) {
        AsyncImage(
            model = "https://images.unsplash.com/photo-1496747611176-843222e1e57c?w=1600&q=85",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge, vertical = 56.dp)
        ) {
            Eyebrow("THE EDITORIAL  ·  CHAPTER IV", color = AuraColors.Bronze)
            Spacer(Modifier.height(24.dp))
            Text(
                text = "An autumn told in cashmere and silence.",
                style = MaterialTheme.typography.headlineLarge,
                color = AuraColors.Ink
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Photographed against the slate-grey light of late October in the Loire, " +
                        "our fourth chapter dwells on the things that need no announcement — " +
                        "a perfectly cut camel coat, the weight of vicuña wool, " +
                        "the patina of a worn leather satchel.",
                style = MaterialTheme.typography.bodyLarge,
                color = AuraColors.Espresso
            )
            Spacer(Modifier.height(28.dp))
            AuraButton(
                label = "Read the Story",
                onClick = { },
                variant = AuraButtonVariant.OnLight
            )
        }
    }
}

/* ─────────────────────────────────── New Arrivals ─── */

@Composable
private fun NewArrivalsSection(onOpenProduct: (String) -> Unit) {
    val products = ProductRepository.newArrivals()
    Column(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Ink)
            .padding(vertical = 80.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Eyebrow("JUST ARRIVED  ·  N° 26")
            Spacer(Modifier.height(20.dp))
            Text(
                text = "The New Arrivals",
                style = MaterialTheme.typography.displaySmall,
                color = AuraColors.Ivory
            )
        }
        Spacer(Modifier.height(40.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = AuraSpacing.edge),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(products, key = { it.id }) { p ->
                Box(Modifier.width(260.dp)) {
                    ProductCard(
                        product = p,
                        onClick = { onOpenProduct(p.id) }
                    )
                }
            }
        }
        Spacer(Modifier.height(40.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge),
            contentAlignment = Alignment.Center
        ) {
            AuraButton(
                label = "The Full Collection",
                onClick = { },
                variant = AuraButtonVariant.Primary
            )
        }
    }
}

/* ─────────────────────────────────── Heritage ─── */

@Composable
private fun HeritageSection() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Espresso)
            .padding(horizontal = AuraSpacing.edge, vertical = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Eyebrow("AN HEIRLOOM IN THE MAKING")
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Founded in 1920. Held to the same standard a hundred years on.",
            style = MaterialTheme.typography.headlineMedium.copy(fontStyle = FontStyle.Italic),
            color = AuraColors.Ivory
        )
        Spacer(Modifier.height(56.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Stat("104", "YEARS")
            Stat("7", "ATELIERS")
            Stat("386", "ARTISANS")
            Stat("42", "CITIES")
        }
    }
}

@Composable
private fun Stat(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = number,
            style = MaterialTheme.typography.displaySmall,
            color = AuraColors.Champagne
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Bone.copy(alpha = 0.7f)
        )
    }
}

/* ─────────────────────────────────── Clientele ─── */

@Composable
private fun ClienteleSection() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Ivory)
            .padding(horizontal = AuraSpacing.edge, vertical = 80.dp)
    ) {
        Eyebrow("THE PRIVATE SALON", color = AuraColors.Bronze)
        Spacer(Modifier.height(24.dp))
        Text(
            text = "An invitation, discreetly extended.",
            style = MaterialTheme.typography.displaySmall,
            color = AuraColors.Ink
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Receive first viewings of upcoming collections, personal styling at the house, " +
                    "and quiet news from our workshops. No newsletters. No noise. " +
                    "Only what is worth your time.",
            style = MaterialTheme.typography.bodyLarge,
            color = AuraColors.Espresso
        )
        Spacer(Modifier.height(36.dp))
        // Subscription input
        Column {
            Text(
                "YOUR PRIVATE ADDRESS",
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Bronze
            )
            Spacer(Modifier.height(8.dp))
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(AuraColors.Ink)
            )
            Spacer(Modifier.height(24.dp))
            AuraButton(
                label = "Enter",
                onClick = { },
                variant = AuraButtonVariant.OnLight
            )
        }
        Spacer(Modifier.height(56.dp))
        // Services list
        ServiceLine("Personal Stylist", "WORLDWIDE  ·  BY APPOINTMENT")
        ServiceLine("Bespoke Tailoring", "PARIS · MILAN · LONDON")
        ServiceLine("Private Salon Viewings", "FOR THE HOUSE CLIENTELE")
        ServiceLine("Lifetime Restoration", "EVERY PIECE. FOR ALWAYS.")
        ServiceLine("White-Glove Delivery", "42 CITIES", isLast = true)
    }
}

@Composable
private fun ServiceLine(name: String, desc: String, isLast: Boolean = false) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                color = AuraColors.Ink
            )
            Text(
                text = desc,
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Bronze
            )
        }
        if (!isLast) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(AuraColors.HairInk)
            )
        }
    }
}

/* ─────────────────────────────────── Footer ─── */

@Composable
private fun FooterSection() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(AuraColors.Ink)
            .padding(horizontal = AuraSpacing.edge, vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AURA",
            style = MaterialTheme.typography.displayLarge,
            color = AuraColors.Ivory
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Style That Speaks",
            style = MaterialTheme.typography.headlineSmall.copy(fontStyle = FontStyle.Italic),
            color = AuraColors.Champagne
        )
        Spacer(Modifier.height(56.dp))
        Hairline()
        Spacer(Modifier.height(40.dp))

        FooterColumn("THE HOUSE", listOf("Our Heritage", "The Workshops", "Sustainability", "Press", "Careers"))
        Spacer(Modifier.height(32.dp))
        FooterColumn("SERVICES", listOf("Personal Stylist", "Bespoke Workshop", "Lifetime Restoration", "Boutique Finder", "Order Tracking"))
        Spacer(Modifier.height(32.dp))
        FooterColumn("CLIENT CARE", listOf("Contact the House", "Delivery & Returns", "Product Care", "Size Guide", "Frequently Asked"))

        Spacer(Modifier.height(48.dp))
        Hairline()
        Spacer(Modifier.height(20.dp))
        Text(
            text = "© 2026  AURA  ·  ALL RIGHTS RESERVED",
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.5f)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "PARIS  ·  MILAN  ·  LONDON  ·  NEW YORK",
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Ivory.copy(alpha = 0.4f)
        )
    }
}

@Composable
private fun FooterColumn(title: String, items: List<String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = AuraColors.Champagne
        )
        Spacer(Modifier.height(18.dp))
        items.forEach {
            Text(
                text = it,
                style = MaterialTheme.typography.titleLarge,
                color = AuraColors.Ivory.copy(alpha = 0.75f),
                modifier = Modifier.padding(vertical = 6.dp)
            )
        }
    }
}
