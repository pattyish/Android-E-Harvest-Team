//package com.eharvest.cmu.presentaion.search_screen
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.eharvest.cmu.domain.repository.FirebaseRepository
//import com.eharvest.cmu.presentaion.home_screen.getAllproductsState
//import com.eharvest.cmu.util.Resource
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//class SearchScreenViewModel@Inject constructor(
//    private val firebaseRepository: FirebaseRepository
//) : ViewModel() {
//
//    private val _getAllproducts: MutableStateFlow<getAllproductsState> = MutableStateFlow(
//        getAllproductsState()
//    )
//    val getAllproducts: StateFlow<getAllproductsState> = _getAllproducts
//
//    init {
//        getSearchedProducts()
//    }
//
//    private fun getSearchedProducts() = viewModelScope.launch {
//        firebaseRepository.getSearchedProducts().let { result ->
//            when(result){
//                is Resource.Success -> {
//                    _getAllproducts.value = getAllproductsState(productSuccess = result.data)
//                }
//                is Resource.Loading -> {
//                    _getAllproducts.value = getAllproductsState(isLoading = true)
//                }
//                is Resource.Error -> {
//                    _getAllproducts.value = getAllproductsState(error = result.message)
//                }
//            }
//        }
//    }
//}