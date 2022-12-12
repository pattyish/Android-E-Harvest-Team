package com.eharvest.cmu.presentaion.profile_screen

import androidx.lifecycle.ViewModel
import com.eharvest.cmu.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    fun signOut() = firebaseRepository.signOut()


}