package com.aura.app.data.repository

import com.aura.app.data.model.Category
import com.aura.app.data.model.Product

/**
 * The AURA catalogue — curated for the Indian client.
 *
 * Twelve clothing houses split by gender and age band, plus accessories and footwear.
 * Pieces span the spectrum: western, semi-formal, formal, semi-traditional, ethnic,
 * festive, bridal, and old-money classics — priced in Indian rupees.
 *
 * To wire in a real backend, replace this object with calls to your API and keep the
 * `Product` and `Category` data classes intact.
 */
object MockCatalogue {

    // ─────────────────────────────  CATEGORIES  ─────────────────────────────

    val categories: List<Category> = listOf(
        // ── Women's age bands ────────────────────────────────────────────
        Category(
            id = "girls-1-5",
            name = "Little Ones · Girls",
            tagline = "Frocks, festive sets · ages 1–5",
            pieceCount = 24,
            coverImage = "https://images.unsplash.com/photo-1518831959646-742c3a14ebf7?w=1400&q=80",
            accent = "No. 01"
        ),
        Category(
            id = "girls-5-15",
            name = "Juniors · Girls",
            tagline = "Festive, ethnic, party · ages 5–15",
            pieceCount = 38,
            coverImage = "https://images.unsplash.com/photo-1514090458221-65bb69cf63e6?w=1400&q=80",
            accent = "No. 02"
        ),
        Category(
            id = "women-16-21",
            name = "Youth · Women",
            tagline = "Indo-western, party, semi-formal · ages 16–21",
            pieceCount = 64,
            coverImage = "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=1400&q=80",
            accent = "No. 03"
        ),
        Category(
            id = "women-21-35",
            name = "Contemporary · Women",
            tagline = "Saree, lehenga, suit, gown · ages 21–35",
            pieceCount = 142,
            coverImage = "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=1400&q=80",
            accent = "No. 04"
        ),
        Category(
            id = "women-35-50",
            name = "Signature · Women",
            tagline = "Silk saree, anarkali, designer ethnic · ages 35–50",
            pieceCount = 88,
            coverImage = "https://images.unsplash.com/photo-1594969155368-f19485a9d80f?w=1400&q=80",
            accent = "No. 05"
        ),
        Category(
            id = "women-50plus",
            name = "Heritage · Women",
            tagline = "Classic sarees, handloom · ages 50 and beyond",
            pieceCount = 56,
            coverImage = "https://images.unsplash.com/photo-1606293459124-1b1f2f1d3b1e?w=1400&q=80",
            accent = "No. 06"
        ),

        // ── Men's age bands ──────────────────────────────────────────────
        Category(
            id = "boys-1-5",
            name = "Little Ones · Boys",
            tagline = "Kurta sets, rompers · ages 1–5",
            pieceCount = 22,
            coverImage = "https://images.unsplash.com/photo-1564831806746-9c5d6e74e6e7?w=1400&q=80",
            accent = "No. 07"
        ),
        Category(
            id = "boys-5-15",
            name = "Juniors · Boys",
            tagline = "Sherwani, semi-formal, festive · ages 5–15",
            pieceCount = 34,
            coverImage = "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1400&q=80",
            accent = "No. 08"
        ),
        Category(
            id = "men-16-21",
            name = "Youth · Men",
            tagline = "Indo-western, slim suiting, party · ages 16–21",
            pieceCount = 58,
            coverImage = "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1400&q=80",
            accent = "No. 09"
        ),
        Category(
            id = "men-21-35",
            name = "Contemporary · Men",
            tagline = "Bandhgala, suiting, festive kurta · ages 21–35",
            pieceCount = 128,
            coverImage = "https://images.unsplash.com/photo-1593032465175-481ac7f401a0?w=1400&q=80",
            accent = "No. 10"
        ),
        Category(
            id = "men-35-50",
            name = "Signature · Men",
            tagline = "Three-piece, silk kurta, formal · ages 35–50",
            pieceCount = 76,
            coverImage = "https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=1400&q=80",
            accent = "No. 11"
        ),
        Category(
            id = "men-50plus",
            name = "Heritage · Men",
            tagline = "Achkan, classic kurta · ages 50 and beyond",
            pieceCount = 48,
            coverImage = "https://images.unsplash.com/photo-1617137968427-85924c800a22?w=1400&q=80",
            accent = "No. 12"
        ),

        // ── Cross-house ──────────────────────────────────────────────────
        Category(
            id = "accessories",
            name = "Accessories",
            tagline = "Scarves · belts · totes · briefcases",
            pieceCount = 84,
            coverImage = "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=1400&q=80",
            accent = "No. 13"
        ),
        Category(
            id = "footwear",
            name = "Footwear",
            tagline = "Mojari · Kolhapuri · Oxford · heels",
            pieceCount = 62,
            coverImage = "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=1400&q=80",
            accent = "No. 14"
        )
    )

    // ─────────────────────────────  PRODUCTS  ─────────────────────────────

    val products: List<Product> = listOf(

        // ─── Little Ones · Girls (1–5) ──────────────────────────────────
        Product(
            id = "p101",
            name = "Frilled Cotton Frock — Powder",
            category = "girls-1-5",
            subcategory = "Western · Everyday",
            priceCents = 3_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1518831959646-742c3a14ebf7?w=1200&q=85",
                "https://images.unsplash.com/photo-1604881991720-f91add269bed?w=1200&q=85"
            ),
            description = "A tier of soft cotton ruffles with mother-of-pearl buttons at the back. " +
                    "Trimmed with hand-rolled hems and lined for delicate skin.",
            fabric = "100% Cotton Voile · Hand-finished",
            origin = "Crafted in Jaipur",
            sizes = listOf("1Y", "2Y", "3Y", "4Y", "5Y"),
            inStock = 14,
            isNew = true
        ),
        Product(
            id = "p102",
            name = "Mini Lehenga — Mint Embroidered",
            category = "girls-1-5",
            subcategory = "Festive · Ethnic",
            priceCents = 6_800_00,
            images = listOf(
                "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=1200&q=85",
                "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=1200&q=85"
            ),
            description = "A three-piece lehenga set in pistachio dupion with floral thread-work " +
                    "across the choli. Comes with a featherweight tulle dupatta.",
            fabric = "Dupion Silk · Thread Embroidery",
            origin = "Hand-embroidered in Jaipur",
            sizes = listOf("1Y", "2Y", "3Y", "4Y", "5Y"),
            inStock = 8
        ),

        // ─── Juniors · Girls (5–15) ─────────────────────────────────────
        Product(
            id = "p103",
            name = "Anarkali Suit — Soft Coral",
            category = "girls-5-15",
            subcategory = "Festive · Ethnic",
            priceCents = 9_800_00,
            images = listOf(
                "https://images.unsplash.com/photo-1594969155368-f19485a9d80f?w=1200&q=85",
                "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=1200&q=85"
            ),
            description = "A floor-skimming Anarkali in georgette with a fine gota-patti yoke. " +
                    "Paired with a churidar and a chiffon dupatta in matching coral.",
            fabric = "Georgette · Gota-Patti Embroidery",
            origin = "Crafted in Lucknow",
            sizes = listOf("6Y", "8Y", "10Y", "12Y", "14Y"),
            inStock = 11,
            isNew = true
        ),
        Product(
            id = "p104",
            name = "Floral A-Line Dress — Bone",
            category = "girls-5-15",
            subcategory = "Western · Semi-Formal",
            priceCents = 4_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1514090458221-65bb69cf63e6?w=1200&q=85",
                "https://images.unsplash.com/photo-1518831959646-742c3a14ebf7?w=1200&q=85"
            ),
            description = "A boat-neck A-line in printed cotton poplin with a tied sash at the waist. " +
                    "An everyday dress that takes well to a birthday or a brunch.",
            fabric = "Cotton Poplin · Lined",
            origin = "Stitched in Mumbai",
            sizes = listOf("6Y", "8Y", "10Y", "12Y", "14Y"),
            inStock = 19
        ),

        // ─── Youth · Women (16–21) ──────────────────────────────────────
        Product(
            id = "p105",
            name = "Indo-Western Crop Set — Ivory",
            category = "women-16-21",
            subcategory = "Semi-Traditional · Festive",
            priceCents = 14_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=1200&q=85",
                "https://images.unsplash.com/photo-1594969155368-f19485a9d80f?w=1200&q=85"
            ),
            description = "A cropped silk blouse with hand-cut zari work, paired with a sharara " +
                    "in matching ivory. Designed for the modern engagement or sangeet.",
            fabric = "Raw Silk · Zari Embroidery",
            origin = "Tailored in Delhi",
            sizes = listOf("XS", "S", "M", "L"),
            inStock = 6,
            isNew = true
        ),
        Product(
            id = "p106",
            name = "Pleated Mini Dress — Champagne",
            category = "women-16-21",
            subcategory = "Western · Party",
            priceCents = 8_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1496747611176-843222e1e57c?w=1200&q=85",
                "https://images.unsplash.com/photo-1485231183945-fffde7cc0d75?w=1200&q=85"
            ),
            description = "A knife-pleated mini in metallic chiffon with a deep cowl back. " +
                    "Lined throughout. Pairs with a slim stiletto.",
            fabric = "Metallic Chiffon · Fully Lined",
            origin = "Sewn in Mumbai",
            sizes = listOf("XS", "S", "M", "L"),
            inStock = 9
        ),

        // ─── Contemporary · Women (21–35) ───────────────────────────────
        Product(
            id = "p107",
            name = "Banarasi Saree — Crimson & Gold",
            category = "women-21-35",
            subcategory = "Traditional · Festive",
            priceCents = 65_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=1200&q=85",
                "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=1200&q=85"
            ),
            description = "A pure Banarasi silk woven on traditional pit looms. Crimson body with " +
                    "an antique-gold zari border and traditional kadhua butis. Six and a half yards.",
            fabric = "Pure Banarasi Silk · Real Zari",
            origin = "Handwoven in Varanasi, Uttar Pradesh",
            sizes = listOf("Free Size · 6.5 yards"),
            inStock = 4,
            isNew = true
        ),
        Product(
            id = "p108",
            name = "Tailored Pantsuit — Charcoal",
            category = "women-21-35",
            subcategory = "Formal Western · Old Money",
            priceCents = 28_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1483985988355-763728e1935b?w=1200&q=85",
                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1200&q=85"
            ),
            description = "A single-breasted blazer with a slim straight trouser in Italian wool. " +
                    "The quiet uniform of the boardroom — built to be worn for a decade.",
            fabric = "Italian Wool · Half-Canvas Construction",
            origin = "Tailored in Mumbai",
            sizes = listOf("XS", "S", "M", "L", "XL"),
            inStock = 12
        ),
        Product(
            id = "p109",
            name = "Bridal Lehenga — Rose & Vermilion",
            category = "women-21-35",
            subcategory = "Bridal · Ethnic",
            priceCents = 1_85_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1594969155368-f19485a9d80f?w=1200&q=85",
                "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=1200&q=85"
            ),
            description = "A bridal masterpiece — raw silk lehenga embroidered with zardozi, kundan, " +
                    "and Swarovski. Approximately three hundred hours of atelier work per piece. " +
                    "Comes with a matching choli and net dupatta.",
            fabric = "Raw Silk · Zardozi · Kundan · Swarovski",
            origin = "Hand-embroidered in Delhi",
            sizes = listOf("XS", "S", "M", "L"),
            inStock = 2,
            isLimited = true
        ),
        Product(
            id = "p110",
            name = "Cocktail Gown — Champagne Silk",
            category = "women-21-35",
            subcategory = "Semi-Formal · Western",
            priceCents = 42_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1496747611176-843222e1e57c?w=1200&q=85",
                "https://images.unsplash.com/photo-1539109136881-3be0616acf4b?w=1200&q=85"
            ),
            description = "A bias-cut column gown in champagne mulberry silk with a draped cowl neckline " +
                    "and a hand-finished hem. For the reception or the gala.",
            fabric = "Mulberry Silk · French Seams",
            origin = "Sewn in Mumbai",
            sizes = listOf("XS", "S", "M", "L"),
            inStock = 5
        ),

        // ─── Signature · Women (35–50) ──────────────────────────────────
        Product(
            id = "p111",
            name = "Kanjivaram Saree — Olive & Bronze",
            category = "women-35-50",
            subcategory = "Traditional · Heirloom",
            priceCents = 1_25_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=1200&q=85",
                "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=1200&q=85"
            ),
            description = "A Kanjivaram in temple-border olive with a bronze pallu of woven peacocks. " +
                    "Pure mulberry silk and pure gold-thread zari. Acquires sheen with each wearing.",
            fabric = "Pure Mulberry Silk · Pure Zari",
            origin = "Handwoven in Kanchipuram, Tamil Nadu",
            sizes = listOf("Free Size · 6.5 yards"),
            inStock = 3,
            isLimited = true
        ),
        Product(
            id = "p112",
            name = "Embroidered Anarkali — Pista Green",
            category = "women-35-50",
            subcategory = "Festive · Ethnic",
            priceCents = 65_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1594969155368-f19485a9d80f?w=1200&q=85",
                "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=1200&q=85"
            ),
            description = "A floor-length Anarkali with hand-done aari work across the bodice " +
                    "in tonal silk thread. Cut for a softer, more flattering silhouette.",
            fabric = "Pure Georgette · Aari Embroidery",
            origin = "Hand-embroidered in Lucknow",
            sizes = listOf("S", "M", "L", "XL"),
            inStock = 7
        ),

        // ─── Heritage · Women (50+) ─────────────────────────────────────
        Product(
            id = "p113",
            name = "Pure Silk Saree — Ivory & Gold",
            category = "women-50plus",
            subcategory = "Classic · Traditional",
            priceCents = 85_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1606293459124-1b1f2f1d3b1e?w=1200&q=85",
                "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=1200&q=85"
            ),
            description = "An ivory pure-silk saree with a wide gold zari border. " +
                    "The kind that quietly anchors a wardrobe across decades — and across generations.",
            fabric = "Pure Mulberry Silk · Gold Zari Border",
            origin = "Woven in Kanchipuram",
            sizes = listOf("Free Size · 6.5 yards"),
            inStock = 6
        ),
        Product(
            id = "p114",
            name = "Cotton Saree — Off-White Handloom",
            category = "women-50plus",
            subcategory = "Everyday · Ethnic",
            priceCents = 12_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1606293459124-1b1f2f1d3b1e?w=1200&q=85",
                "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=1200&q=85"
            ),
            description = "An everyday handloom in off-white cotton with a thin maroon border. " +
                    "Soft, breathable, and a little more refined with each wash.",
            fabric = "Handloom Cotton · Natural Dye",
            origin = "Handloom · Phulia, West Bengal",
            sizes = listOf("Free Size · 6 yards"),
            inStock = 22
        ),

        // ─── Little Ones · Boys (1–5) ───────────────────────────────────
        Product(
            id = "p201",
            name = "Kurta Pyjama Set — Bone Cotton",
            category = "boys-1-5",
            subcategory = "Festive · Ethnic",
            priceCents = 4_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1564831806746-9c5d6e74e6e7?w=1200&q=85",
                "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1200&q=85"
            ),
            description = "A two-piece kurta and pyjama in fine cotton, with mother-of-pearl button " +
                    "placket and a hand-finished hem. Built to last through several festivals.",
            fabric = "100% Cotton · Hand-Finished",
            origin = "Stitched in Jaipur",
            sizes = listOf("1Y", "2Y", "3Y", "4Y", "5Y"),
            inStock = 15,
            isNew = true
        ),
        Product(
            id = "p202",
            name = "Bandhgala Set — Mini Navy",
            category = "boys-1-5",
            subcategory = "Formal · Ethnic",
            priceCents = 7_800_00,
            images = listOf(
                "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1200&q=85",
                "https://images.unsplash.com/photo-1564831806746-9c5d6e74e6e7?w=1200&q=85"
            ),
            description = "A miniature bandhgala in midnight wool with a mandarin collar. " +
                    "Paired with churidar trousers in tonal cream. Wedding-ready from age one.",
            fabric = "Wool · Silk-Lined",
            origin = "Tailored in Delhi",
            sizes = listOf("1Y", "2Y", "3Y", "4Y", "5Y"),
            inStock = 9
        ),

        // ─── Juniors · Boys (5–15) ──────────────────────────────────────
        Product(
            id = "p203",
            name = "Sherwani — Ivory & Gold",
            category = "boys-5-15",
            subcategory = "Wedding · Festive",
            priceCents = 18_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1200&q=85",
                "https://images.unsplash.com/photo-1593032465175-481ac7f401a0?w=1200&q=85"
            ),
            description = "A floor-skimming sherwani in raw silk with hand-done zari placement " +
                    "across the chest. Paired with a churidar and a tonal stole.",
            fabric = "Raw Silk · Zari Embroidery",
            origin = "Tailored in Delhi",
            sizes = listOf("6Y", "8Y", "10Y", "12Y", "14Y"),
            inStock = 6,
            isNew = true
        ),
        Product(
            id = "p204",
            name = "Cotton-Linen Set — Sand",
            category = "boys-5-15",
            subcategory = "Semi-Formal · Western",
            priceCents = 6_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1564831806746-9c5d6e74e6e7?w=1200&q=85",
                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1200&q=85"
            ),
            description = "A two-piece shirt and trouser in cotton-linen with a one-button collar " +
                    "and a flat-front trouser. The summer wedding uniform.",
            fabric = "Cotton-Linen Blend · Lined",
            origin = "Stitched in Mumbai",
            sizes = listOf("6Y", "8Y", "10Y", "12Y", "14Y"),
            inStock = 12
        ),

        // ─── Youth · Men (16–21) ────────────────────────────────────────
        Product(
            id = "p205",
            name = "Indo-Western Bandhgala — Black",
            category = "men-16-21",
            subcategory = "Semi-Traditional · Festive",
            priceCents = 22_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1593032465175-481ac7f401a0?w=1200&q=85",
                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1200&q=85"
            ),
            description = "A short bandhgala jacket in textured black silk, worn over a kurta " +
                    "and tailored trousers. The contemporary alternative to a suit.",
            fabric = "Textured Silk · Silk-Lined",
            origin = "Tailored in Mumbai",
            sizes = listOf("38", "40", "42", "44"),
            inStock = 8,
            isNew = true
        ),
        Product(
            id = "p206",
            name = "Slim-Fit Suit — Midnight Blue",
            category = "men-16-21",
            subcategory = "Formal · Western",
            priceCents = 35_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1200&q=85",
                "https://images.unsplash.com/photo-1593032465175-481ac7f401a0?w=1200&q=85"
            ),
            description = "A two-piece slim-fit suit in midnight wool. Soft-shouldered, " +
                    "single-breasted, peak-lapel. A first proper suit done properly.",
            fabric = "Pure Wool · Half-Canvas",
            origin = "Tailored in Mumbai",
            sizes = listOf("38", "40", "42", "44"),
            inStock = 10
        ),

        // ─── Contemporary · Men (21–35) ─────────────────────────────────
        Product(
            id = "p207",
            name = "Linen Kurta Pyjama — Sage",
            category = "men-21-35",
            subcategory = "Casual · Ethnic",
            priceCents = 14_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1200&q=85",
                "https://images.unsplash.com/photo-1564831806746-9c5d6e74e6e7?w=1200&q=85"
            ),
            description = "A washed-linen kurta in sage with a self-fabric mandarin collar, " +
                    "worn over a relaxed pyjama trouser. The weekend uniform of the Indian city.",
            fabric = "Washed Linen · Mother-of-Pearl Buttons",
            origin = "Stitched in Jaipur",
            sizes = listOf("S", "M", "L", "XL"),
            inStock = 16
        ),
        Product(
            id = "p208",
            name = "Two-Piece Suit — Charcoal Pinstripe",
            category = "men-21-35",
            subcategory = "Formal · Old Money",
            priceCents = 45_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1200&q=85",
                "https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=1200&q=85"
            ),
            description = "A two-button single-breasted suit in Super 120s wool with a quiet " +
                    "chalk pinstripe. Half-canvas construction; reads as solid from across a room.",
            fabric = "Super 120s Wool · Half-Canvas",
            origin = "Tailored in Mumbai",
            sizes = listOf("38", "40", "42", "44", "46"),
            inStock = 11,
            isNew = true
        ),
        Product(
            id = "p209",
            name = "Bandhgala Coat — Black Silk",
            category = "men-21-35",
            subcategory = "Formal · Ethnic",
            priceCents = 38_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1593032465175-481ac7f401a0?w=1200&q=85",
                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1200&q=85"
            ),
            description = "A long bandhgala in black silk-wool, with a stand collar and " +
                    "buttoned cuffs. Sharp enough for a Delhi wedding, restrained enough for any other.",
            fabric = "Silk-Wool Blend · Silk-Lined",
            origin = "Tailored in Delhi",
            sizes = listOf("38", "40", "42", "44"),
            inStock = 7
        ),

        // ─── Signature · Men (35–50) ────────────────────────────────────
        Product(
            id = "p210",
            name = "Three-Piece Suit — Glen Plaid",
            category = "men-35-50",
            subcategory = "Old Money · Formal",
            priceCents = 95_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=1200&q=85",
                "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=1200&q=85"
            ),
            description = "A three-piece in classic Glen Urquhart plaid — peak lapels, " +
                    "double-breasted waistcoat, and a softly tapered trouser. Full canvas. Made to last twenty years.",
            fabric = "Italian Wool · Full Canvas",
            origin = "Tailored in Mumbai",
            sizes = listOf("40", "42", "44", "46"),
            inStock = 4,
            isLimited = true
        ),
        Product(
            id = "p211",
            name = "Pure Silk Kurta — Bronze",
            category = "men-35-50",
            subcategory = "Festive · Ethnic",
            priceCents = 28_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1200&q=85",
                "https://images.unsplash.com/photo-1593032465175-481ac7f401a0?w=1200&q=85"
            ),
            description = "A pure raw-silk kurta in burnished bronze with a band collar and " +
                    "self-piping at the placket. Paired with a churidar in tonal ivory.",
            fabric = "Raw Silk · Hand-Finished",
            origin = "Tailored in Jaipur",
            sizes = listOf("S", "M", "L", "XL"),
            inStock = 9
        ),

        // ─── Heritage · Men (50+) ───────────────────────────────────────
        Product(
            id = "p212",
            name = "Silk Achkan — Beige & Gold",
            category = "men-50plus",
            subcategory = "Classic · Festive",
            priceCents = 75_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1617137968427-85924c800a22?w=1200&q=85",
                "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1200&q=85"
            ),
            description = "A long-form achkan in beige raw silk with a fine gold zari placket, " +
                    "cut for a dignified line. Worn for the most important occasions.",
            fabric = "Raw Silk · Real Zari",
            origin = "Tailored in Lucknow",
            sizes = listOf("40", "42", "44", "46"),
            inStock = 5
        ),
        Product(
            id = "p213",
            name = "Cotton Kurta — Bone White",
            category = "men-50plus",
            subcategory = "Everyday · Ethnic",
            priceCents = 6_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1622237107562-cea0a32bb96d?w=1200&q=85",
                "https://images.unsplash.com/photo-1564831806746-9c5d6e74e6e7?w=1200&q=85"
            ),
            description = "The everyday kurta — handloom cotton in bone white with a flat collar " +
                    "and side slits. A wardrobe foundation, kept simple on purpose.",
            fabric = "Handloom Cotton · Hand-Finished",
            origin = "Handloom · Maheshwar",
            sizes = listOf("M", "L", "XL", "XXL"),
            inStock = 28
        ),

        // ─── Accessories ────────────────────────────────────────────────
        Product(
            id = "p301",
            name = "Pashmina Scarf — Champagne",
            category = "accessories",
            subcategory = "Scarf",
            priceCents = 18_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1601925240970-98447ddbb7e1?w=1200&q=85",
                "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=1200&q=85"
            ),
            description = "A pure pashmina shawl, hand-spun and hand-loomed. " +
                    "Two hundred grams of warmth, pulled through a wedding ring.",
            fabric = "100% Pashmina · Hand-Loomed",
            origin = "Kashmir · Hand-Loomed",
            sizes = listOf("70 × 200 cm"),
            inStock = 12,
            isNew = true
        ),
        Product(
            id = "p302",
            name = "Hand-Stitched Belt — Cognac",
            category = "accessories",
            subcategory = "Belt",
            priceCents = 8_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=1200&q=85",
                "https://images.unsplash.com/photo-1584917865442-de89df76afd3?w=1200&q=85"
            ),
            description = "A 32mm belt in vegetable-tanned calf with a hand-cast brass buckle. " +
                    "Hand-stitched along both edges. Develops a deep patina with wear.",
            fabric = "Calfskin · Vegetable-Tanned · Brass Buckle",
            origin = "Hand-stitched in Kanpur",
            sizes = listOf("34", "36", "38", "40", "42"),
            inStock = 18
        ),
        Product(
            id = "p303",
            name = "Small Tote — Mahogany",
            category = "accessories",
            subcategory = "Small Tote",
            priceCents = 35_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=1200&q=85",
                "https://images.unsplash.com/photo-1584917865442-de89df76afd3?w=1200&q=85"
            ),
            description = "A compact day tote in saddle-grade calf. Structured base, soft top, " +
                    "and a suede interior. Holds the essentials with grace.",
            fabric = "Calfskin · Suede-Lined · Brass Hardware",
            origin = "Hand-finished in Mumbai",
            sizes = listOf("Small · 28 × 22 cm"),
            inStock = 7
        ),
        Product(
            id = "p304",
            name = "Office Tote — Espresso",
            category = "accessories",
            subcategory = "Office Tote",
            priceCents = 55_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=1200&q=85",
                "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=1200&q=85"
            ),
            description = "An A4 tote built for the working week — a fifteen-inch laptop compartment, " +
                    "a card slip inside, and reinforced corners. Hand-stitched along every seam.",
            fabric = "Pebble Calfskin · Suede-Lined",
            origin = "Hand-finished in Mumbai",
            sizes = listOf("Large · 38 × 30 cm"),
            inStock = 9,
            isNew = true
        ),
        Product(
            id = "p305",
            name = "Men's Briefcase — Black Pebble",
            category = "accessories",
            subcategory = "Men's Office Bag",
            priceCents = 68_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=1200&q=85",
                "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=1200&q=85"
            ),
            description = "A flat-frame briefcase in black pebble leather with a brass clasp closure. " +
                    "Fits a sixteen-inch laptop, a notebook, and the day's papers — and looks better in five years than in one.",
            fabric = "Pebble Calfskin · Solid Brass Hardware",
            origin = "Hand-finished in Mumbai",
            sizes = listOf("Standard · 40 × 30 cm"),
            inStock = 6,
            isLimited = true
        ),

        // ─── Footwear ───────────────────────────────────────────────────
        Product(
            id = "p401",
            name = "Kolhapuri Chappal — Tan",
            category = "footwear",
            subcategory = "Traditional · Unisex",
            priceCents = 3_800_00,
            images = listOf(
                "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=1200&q=85",
                "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=1200&q=85"
            ),
            description = "Hand-cut Kolhapuri chappals in vegetable-tanned buffalo hide. " +
                    "Plaited toe-loop, hand-stitched sole. Soft from the first wearing.",
            fabric = "Buffalo Hide · Vegetable-Tanned · Hand-Stitched",
            origin = "Hand-cut in Kolhapur, Maharashtra",
            sizes = listOf("6", "7", "8", "9", "10", "11"),
            inStock = 24
        ),
        Product(
            id = "p402",
            name = "Embroidered Mojari — Ivory & Gold",
            category = "footwear",
            subcategory = "Festive · Ethnic",
            priceCents = 6_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=1200&q=85",
                "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=1200&q=85"
            ),
            description = "A pointed-toe mojari in ivory silk with hand-done gold zari work " +
                    "across the vamp. Designed for the wedding evening; built to last beyond it.",
            fabric = "Silk Upper · Zari Embroidery · Leather Sole",
            origin = "Hand-crafted in Jaipur, Rajasthan",
            sizes = listOf("5", "6", "7", "8", "9", "10"),
            inStock = 13,
            isNew = true
        ),
        Product(
            id = "p403",
            name = "Oxford Shoes — Espresso Calf",
            category = "footwear",
            subcategory = "Formal · Men",
            priceCents = 15_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=1200&q=85",
                "https://images.unsplash.com/photo-1614252369475-531eba835eb1?w=1200&q=85"
            ),
            description = "A whole-cut Oxford on a Goodyear welt. A single piece of Italian calf, " +
                    "polished to a deep mirror finish over many hours.",
            fabric = "Italian Calfskin · Goodyear Welted",
            origin = "Handmade in Italy",
            sizes = listOf("7", "8", "9", "10", "11"),
            inStock = 8
        ),
        Product(
            id = "p404",
            name = "Loafers — Cognac Suede",
            category = "footwear",
            subcategory = "Semi-Formal · Men",
            priceCents = 12_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1614252369475-531eba835eb1?w=1200&q=85",
                "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=1200&q=85"
            ),
            description = "A penny loafer in cognac suede on a leather sole. Worn with a linen suit, " +
                    "a tailored trouser, or just a good pair of jeans.",
            fabric = "Italian Suede · Leather Sole",
            origin = "Handmade in Italy",
            sizes = listOf("7", "8", "9", "10", "11"),
            inStock = 11
        ),
        Product(
            id = "p405",
            name = "Block Heels — Espresso",
            category = "footwear",
            subcategory = "Semi-Formal · Women",
            priceCents = 8_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=1200&q=85",
                "https://images.unsplash.com/photo-1614252369475-531eba835eb1?w=1200&q=85"
            ),
            description = "A 55mm block heel in espresso napa, with a softly squared toe. " +
                    "The day-to-evening shoe — comfortable enough for the office, dressed enough for dinner.",
            fabric = "Napa Leather · Leather-Lined",
            origin = "Handmade in Italy",
            sizes = listOf("4", "5", "6", "7", "8", "9"),
            inStock = 15
        ),
        Product(
            id = "p406",
            name = "Stiletto Heels — Nude Patent",
            category = "footwear",
            subcategory = "Formal · Women",
            priceCents = 14_000_00,
            images = listOf(
                "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=1200&q=85",
                "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=1200&q=85"
            ),
            description = "A 100mm pointed stiletto in nude patent calf. The strap-free " +
                    "evening shoe that lengthens every silhouette.",
            fabric = "Patent Calfskin · Italian-Made",
            origin = "Handmade in Italy",
            sizes = listOf("4", "5", "6", "7", "8", "9"),
            inStock = 7
        ),
        Product(
            id = "p407",
            name = "Sneakers — Bone Leather",
            category = "footwear",
            subcategory = "Casual · Western · Unisex",
            priceCents = 9_500_00,
            images = listOf(
                "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=1200&q=85",
                "https://images.unsplash.com/photo-1614252369475-531eba835eb1?w=1200&q=85"
            ),
            description = "A low-top sneaker in soft bone-coloured calfskin. " +
                    "Simple, unbranded, easy to wear with anything — denim, a suit, or a kurta.",
            fabric = "Calfskin · Cushioned Foot-Bed · Rubber Sole",
            origin = "Made in Portugal",
            sizes = listOf("6", "7", "8", "9", "10", "11"),
            inStock = 18,
            isNew = true
        )
    )

    // ─────────────────────────────  ACCESSORS  ─────────────────────────────

    fun byId(id: String): Product? = products.firstOrNull { it.id == id }
    fun byCategory(categoryId: String): List<Product> =
        products.filter { it.category == categoryId }

    fun newArrivals(): List<Product> = products.filter { it.isNew }
    fun curated(): List<Product> = products.take(8)
}
