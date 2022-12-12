package com.eharvest.cmu.presentaion.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eharvest.cmu.domain.repository.FirebaseRepository
import com.eharvest.cmu.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _getAllproducts: MutableStateFlow<getAllproductsState> = MutableStateFlow(
        getAllproductsState()
    )
    val getAllproducts: StateFlow<getAllproductsState> = _getAllproducts

    init {
        getAllproducts()
    }

    private fun getAllproducts() = viewModelScope.launch {
        firebaseRepository.getAllproducts().let { result ->
            when(result){
                is Resource.Success -> {
                    _getAllproducts.value = getAllproductsState(coffeeSuccess = result.data)
                }
                is Resource.Loading -> {
                    _getAllproducts.value = getAllproductsState(isLoading = true)
                }
                is Resource.Error -> {
                    _getAllproducts.value = getAllproductsState(error = result.message)
                }
            }
        }
    }
}