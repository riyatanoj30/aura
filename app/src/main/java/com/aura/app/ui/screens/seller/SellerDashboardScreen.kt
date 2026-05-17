package com.aura.app.ui.screens.seller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class SellerProduct(
    val name: String,
    val price: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SellerDashboardScreen(
    onBack: () -> Unit = {}
) {

    val products = listOf(
        SellerProduct("Aura Premium Jacket", "₹4,999"),
        SellerProduct("Old Money Shirt", "₹2,499"),
        SellerProduct("Luxury Trousers", "₹3,299"),
        SellerProduct("Classic Watch", "₹7,999")
    )

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("Seller Dashboard")
                }
            )
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    // TODO: Add Product
                }
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Product"
                )
            }
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            verticalArrangement = Arrangement.spacedBy(12.dp),

            contentPadding = PaddingValues(16.dp)
        ) {

            items(products) { product ->

                Card(
                    modifier = Modifier.fillMaxWidth(),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Default.ShoppingBag,
                            contentDescription = null
                        )

                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Text(
                            text = product.price,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}
