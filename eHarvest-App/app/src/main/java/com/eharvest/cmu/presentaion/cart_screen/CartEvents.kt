package com.eharvest.cmu.presentaion.cart_screen

import com.eharvest.cmu.model.CartProducts

sealed class CartEvents {
    data class DeleteProduct(val coin: CartProducts) : CartEvents()
    object Nothing : CartEvents()

}