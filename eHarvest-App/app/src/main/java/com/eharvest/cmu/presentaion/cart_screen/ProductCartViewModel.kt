package com.eharvest.cmu.presentaion.cart_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eharvest.cmu.domain.model.CartProducts
import com.eharvest.cmu.domain.repository.FirebaseRepository
import com.eharvest.cmu.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductCartViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _cartState = mutableStateOf(CartState())
    val cartState: State<CartState> = _cartState

    private val currentUser = firebaseRepository.currentUser()


    suspend fun adduProductToCart(cartProduct: CartProducts) {
        if (currentUser != null) {
            val uid = currentUser.uid
            viewModelScope.launch {
                firebaseRepository.adduProductToCart(cartProduct, uid).collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _cartState.value =
                                CartState(productAddedToCart = "Product Added Successfully")
                        }
                        is Resource.Error -> {
                            _cartState.value = CartState(error = "Sorry!! There was a problem")
                        }
                        is Resource.Loading -> {
                            _cartState.value = CartState(isLoading = true)
                        }
                    }
                }
            }
        }
    }
}