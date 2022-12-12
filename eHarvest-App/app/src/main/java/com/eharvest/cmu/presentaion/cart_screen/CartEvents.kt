package com.eharvest.cmu.presentaion.cart_screen

import com.eharvest.cmu.domain.model.CartProducts

sealed class CartEvents {
    data class DeleteCoffee(val coin: CartProducts) : CartEvents()
    object Nothing : CartEvents()

}