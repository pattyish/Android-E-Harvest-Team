package com.eharvest.cmu.presentaion.cart_screen

import com.eharvest.cmu.domain.model.CartProducts

data class CartProductState(
    val isLoading: Boolean = true,
    val cartProduct: List<CartProducts> = emptyList(),
    val error: String? = null,


    )