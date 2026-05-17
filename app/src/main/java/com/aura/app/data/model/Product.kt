package com.aura.app.data.model

data class Product(
    val id: String,
    val name: String,
    val category: String,
    val subcategory: String,
    val priceCents: Long,         // priced in paise (1 rupee = 100 paise)
    val currency: String = "INR",
    val images: List<String>,
    val description: String,
    val fabric: String,
    val origin: String,
    val sizes: List<String>,
    val inStock: Int,
    val isNew: Boolean = false,
    val isLimited: Boolean = false,
    val deliveryEstimate: String = "3–5 business days"
) {
    val priceFormatted: String
        get() = "₹ ${formatIndian(priceCents / 100)}"

    companion object {
        /**
         * Indian numbering convention — last three digits, then groups of two.
         * 1,500   ·   12,500   ·   1,50,000   ·   12,50,000   ·   1,25,00,000
         */
        fun formatIndian(amount: Long): String {
            if (amount < 0) return "-${formatIndian(-amount)}"
            val s = amount.toString()
            if (s.length <= 3) return s
            val last3 = s.takeLast(3)
            var rest = s.dropLast(3)
            val groups = mutableListOf<String>()
            while (rest.length > 2) {
                groups.add(0, rest.takeLast(2))
                rest = rest.dropLast(2)
            }
            if (rest.isNotEmpty()) groups.add(0, rest)
            return groups.joinToString(",") + "," + last3
        }
    }
}
