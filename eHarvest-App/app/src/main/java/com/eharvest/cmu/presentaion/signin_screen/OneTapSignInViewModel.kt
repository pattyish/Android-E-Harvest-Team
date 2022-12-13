package com.eharvest.cmu.presentaion.signin_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eharvest.cmu.model.AuthUser
import com.eharvest.cmu.domain.repository.GoogleSignInRepository
import com.eharvest.cmu.util.Resource
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OneTapSignInViewModel @Inject constructor(
    private val repository: GoogleSignInRepository,

    ) : ViewModel() {

    private val _googleSingInState: MutableStateFlow<SignInWithGoogleState> = MutableStateFlow(
        SignInWithGoogleState()
    )
    val googleSingInState: StateFlow<SignInWithGoogleState> = _googleSingInState

    fun signInWithGoogleCredentials(credential: AuthCredential,user: AuthUser) = viewModelScope.launch {

        repository.signInWithCredential(credential, user ).collect { result ->
            when (result) {
                is Resource.Loading -> {
                    _googleSingInState.value = SignInWithGoogleState(isLoading = true)
                }
                is Resource.Success -> {
                    _googleSingInState.value = SignInWithGoogleState(success = result.data)
                }
                is Resource.Error -> {
                    _googleSingInState.value = SignInWithGoogleState(error = result.message)
                }
            }


        }
    }

}