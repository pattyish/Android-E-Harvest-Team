package com.eharvest.cmu.domain.repository

import com.eharvest.cmu.domain.model.AuthUser
import com.eharvest.cmu.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface GoogleSignInRepository {

    suspend fun addUserToFireStore()

    fun signInWithCredential(
        credentials: AuthCredential,
        user: AuthUser
    ): Flow<Resource<AuthResult>>

}