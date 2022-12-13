package com.eharvest.cmu.presentaion.cart_screen

data class CartState(
    val productDeleted: Boolean = false,
    val productAddedToCart: String? = "",
    val error: String? = "",
    val isLoading: Boolean = false
)
