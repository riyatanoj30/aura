# AURA — Style That Speaks

A luxury fashion e-commerce Android app, built in Kotlin + Jetpack Compose. Old-money editorial aesthetic — matte black, champagne gold, ivory — modelled on the visual restraint of Hermès, Loro Piana, The Row, and Tom Ford.

---

## Quick start

1. **Open in Android Studio** — Hedgehog (2023.1) or newer.
2. **Let Gradle sync** — it will download:
   - Android Gradle Plugin 8.5.2
   - Kotlin 2.0.20 (with the new Compose compiler plugin)
   - Jetpack Compose BOM `2024.09.03`
   - Coil 2.7 (image loading)
3. **Run on a device or emulator** running API 24 (Android 7) or higher.

That's it. No keys, no backend, no .env. The catalogue is bundled as in-memory mock data in `data/repository/MockCatalogue.kt`.

> First launch: the Italiana + Cormorant Garamond + Jost fonts download from Google Fonts on first use (the certificates in `res/values/font_certs.xml` authorise that). After that they're cached. If the device has no network, the app falls back to system fonts but the typography will look noticeably less editorial.

---

## What the app does

| Flow | Screens |
| --- | --- |
| **Buyer** | Splash → Home → Category → Product Detail → Cart → Checkout → Order Tracking; plus Wishlist, Search, Profile |
| **Seller** | Seller Studio dashboard (inventory, KPIs, action cards) |
| **Admin** | Operations Room (approvals, seller verification, banner management) |

All screens are reachable from **Profile → Professional Access** (Seller Studio / House Administration). In a real app these would be gated by role.

---

## Project layout

```
app/
└── src/main/
    ├── AndroidManifest.xml
    ├── res/                                 ← themes, colours, splash icon, font certs
    └── java/com/aura/app/
        ├── AuraApplication.kt
        ├── MainActivity.kt                  ← edge-to-edge entry point
        ├── data/
        │   ├── model/                       ← Product, Category, CartItem, Order
        │   └── repository/                  ← Mock catalogue + Cart/Wishlist singletons
        └── ui/
            ├── theme/                       ← AuraColors, AuraTypography, AuraTheme
            ├── components/                  ← AuraButton, Eyebrow, ProductCard, CategoryCard, TopBar
            ├── navigation/                  ← Routes + NavHost
            └── screens/
                ├── splash/        — staggered AURA letter reveal
                ├── home/          — hero, philosophy, collections, editorial, arrivals, heritage, footer
                ├── category/      — editorial cover + 2-col product grid
                ├── product/       — image pager, fabric details, size picker, sticky CTA
                ├── cart/          — line items, quantity stepper, subtotal, checkout CTA
                ├── checkout/      — single-column form, encrypted payment line, order summary
                ├── orders/        — confirmation, timeline (Received → Atelier → Transit → Delivered)
                ├── wishlist/      — saved-pieces grid
                ├── search/        — type-ahead with editorial empty state
                ├── profile/       — clientele tier, activity, preferences, professional access
                ├── seller/        — KPI strip, action cards, recent inventory
                └── admin/         — 4 KPI tiles, approval queues, banner management
```

---

## Design system

Everything that matters about the look lives in three files:

### `ui/theme/Color.kt`
The palette is six warm-blacks and warm-whites, plus champagne gold as the only accent.

| Token | Hex | Used for |
| --- | --- | --- |
| `Ink` | `#0B0908` | Primary background (warm matte black) |
| `Smoke` | `#1A1614` | Raised surfaces (cards) |
| `Espresso` | `#2B1810` | Heritage / admin section background |
| `Champagne` | `#C9A961` | The accent — hairlines, micro-caps, prices |
| `Bronze` | `#8B6F47` | Secondary accent on light surfaces |
| `Ivory` | `#F5F1EA` | Primary text on dark |
| `Bone` | `#ECE5D8` | Light surface backgrounds |
| `HairLight` | `rgba(245,241,234,0.14)` | The universal divider |

Gold is **never** used as a button fill. Only as 1 dp lines, small caps, and a single ornamental rule per section. That restraint is what separates luxury from "looks expensive."

### `ui/theme/Type.kt`
Three Google Fonts pulled at runtime via the downloadable-fonts API:

- **Italiana** — display wordmark (the "AURA" mark, hero titles)
- **Cormorant Garamond** — editorial serifs (headlines, product names, prices)
- **Jost** — utility sans (nav, buttons, labels, body)

All-caps text sits at 0.22em–0.40em letter-spacing. This is the single most important typographic detail in luxury fashion.

### `ui/components/AuraButton.kt`
Hairline-outlined. Never filled by default. Animates a fill on press/hover. Three variants: `Primary` (champagne border), `Ghost` (bone hairline), `OnLight` (ink border for light surfaces). Includes a 1-pixel arrow tip that grows on interaction.

---

## Swapping in real data

The repository singletons in `data/repository/` are the only place fake data lives. To wire up a backend:

1. Replace the bodies of `ProductRepository`, `CartRepository`, `WishlistRepository` with calls to your network layer (Retrofit, Ktor, etc.).
2. The screens read via `StateFlow.collectAsState()` — no UI changes needed.
3. Add a DI framework (Hilt) when the dependency graph justifies it.

The mock catalogue is 12 products across 6 categories — enough to make every screen feel populated, small enough that you can scroll through it in five seconds.

---

## What's intentionally not here

- **No Hilt** — premature DI on a project this size adds compile time without benefit. The singletons are easy to replace.
- **No Room** — cart is in-memory; a real version persists with DataStore or a server cart.
- **No payment SDK** — checkout placeholder simulates order placement and clears the cart.
- **No login** — the profile screen assumes a logged-in clientele member.
- **No analytics, no crash reporting, no feature flags** — production hygiene that doesn't affect the design system.

Each of these is a one-day addition once the brand foundation is approved.

---

## Notes on the brand identity

The brief specified six brand inspirations spanning Ralph Lauren → Balenciaga. The app commits firmly to the *quiet luxury* end of that spectrum — closer to Hermès and Loro Piana than to streetwear-luxury. Reasons:

1. **Old money does not announce itself.** Big logos, gradient buttons, urgency banners ("Only 2 left!") would betray the brief's first three keywords (Wealth · Elegance · Exclusivity).
2. **Restraint scales.** The same components that build the homepage work for the admin panel without re-designing.
3. **Mobile favours quiet.** Small screens are unforgiving of visual noise. The less the chrome insists, the more the photography speaks.

If a louder direction is wanted, the easiest dial to turn is `AuraColors`: warming the gold toward `#D4AF37` and using it on full button fills moves the brand 30% closer to Balenciaga/Versace without touching layout.

---

## Roadmap

The natural next milestones:

1. Replace the system splash with a Lottie animation of the wordmark drawing itself
2. Real product-image zoom (pinch + double-tap) on the PDP carousel
3. Live stock / delivery API integration on PDP
4. Sign-in flow (passkey-first, email fallback) feeding the Profile screen
5. Lottie + slow-zoom cinematic hero on Home
6. Wider tablet layouts (the design works as-is at 600 dp, but two-up product grids could become three or four)

— *AURA · 2026*
