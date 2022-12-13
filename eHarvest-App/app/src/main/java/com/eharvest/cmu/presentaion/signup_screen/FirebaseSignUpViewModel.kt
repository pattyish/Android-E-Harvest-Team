package com.eharvest.cmu.presentaion.signin_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eharvest.cmu.model.AuthUser
import com.eharvest.cmu.domain.repository.FirebaseRepository
import com.eharvest.cmu.presentaion.signup_screen.FirebaseSignUpState
import com.eharvest.cmu.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseSignupViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _signUpState = Channel<FirebaseSignUpState>()
    val signUpState = _signUpState.receiveAsFlow()


    fun createUser(user: AuthUser) = viewModelScope.launch {
        firebaseRepository.firebaseSignUp(user).collect { result ->
            when (result) {
                is Resource.Loading -> {
                    _signUpState.send(FirebaseSignUpState(isLoading = true))
                }
                is Resource.Success -> {
                    _signUpState.send(FirebaseSignUpState(isSignedUp = "Signed In Successful"))
                }
                is Resource.Error -> {
                    _signUpState.send(FirebaseSignUpState(error = result.message))
                }
            }
        }
    }
}