package com.eharvest.cmu.presentaion.home_screen

import com.eharvest.cmu.model.Product

data class getAllproductsState(
    val isLoading: Boolean = false,
    val productSuccess: List<Product>? = emptyList(),
    val error: String? = ""
)
