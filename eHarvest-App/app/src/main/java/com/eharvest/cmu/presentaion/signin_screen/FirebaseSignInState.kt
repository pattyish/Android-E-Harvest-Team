package com.eharvest.cmu.presentaion.signin_screen

data class FirebaseSignInState(
    var isLoading: Boolean = false,
    var isSignedIn: String? = null,
    val error: String? = null
)
