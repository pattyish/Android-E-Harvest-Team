package com.eharvest.cmu.presentaion.common

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eharvest.cmu.domain.model.AuthUser
import com.eharvest.cmu.domain.model.CartProducts
import com.eharvest.cmu.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _userState = mutableStateOf(AuthUser())
    val userState: State<AuthUser> = _userState

    private val currentUser = firebaseRepository.currentUser()
    private val userId = currentUser?.uid

    init {
        getUserdata()
    }

    private fun getUserdata() {
        viewModelScope.launch {
            val getUserDataResult = userId.let {
                firebaseRepository.getUserData(it.toString())
            }
            getUserDataResult?.let {
                _userState.value = it
            }
        }
    }

    fun updateUserData() {
        viewModelScope.launch {
            getUserdata()
        }
    }

     fun deleteProductFromCart(cartProducts: CartProducts) {
        // val userId = currentUser?.uid
        viewModelScope.launch {
            firebaseRepository.deleteProductFromCart(userId.toString(), cartProduct = cartProducts)
        }
    }


}