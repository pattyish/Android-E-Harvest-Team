package com.eharvest.cmu.presentaion.home_screen

import com.eharvest.cmu.domain.model.Product

data class getAllproductsState(
    val isLoading: Boolean = false,
    val coffeeSuccess: List<Product>? = emptyList(),
    val error: String? = ""
)
