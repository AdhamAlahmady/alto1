package com.example.inventory.data

data class InventoryItem(
    val id: String,
    val productName: String,
    val barcode: String,
    val quantity: Int,
    val expiryDate: String
)