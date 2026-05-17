package com.aura.app.data.model

data class Category(
    val id: String,
    val name: String,
    val tagline: String,
    val pieceCount: Int,
    val coverImage: String,
    val accent: String   // e.g. "No. 01"
)
