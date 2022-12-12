package com.eharvest.cmu.presentaion.cart_screen

import com.eharvest.cmu.domain.model.CartProducts

data class CartCoffeeState(
    val isLoading: Boolean = true,
    val cartCoffee: List<CartProducts> = emptyList(),
    val error: String? = null,


    )