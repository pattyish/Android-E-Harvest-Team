package com.eharvest.cmu.presentaion.order_screen

import android.app.Application
import android.widget.Toast
import androidx.navigation.NavController
import com.eharvest.cmu.domain.repository.FirebaseRepository
import com.eharvest.cmu.navigation.Screens

class OrderUseCase(
    private val application: Application,
    private val firebaseRepository: FirebaseRepository
) {
    suspend fun addOrders(
        list: MutableList<Order>,
        navController: NavController,
        setLoadingState: (Boolean) -> Unit
    ) {
        fun onSuccess() {
            setLoadingState(false)
            navController.popBackStack()
            navController.navigate(Screens.HomeScreen.route)
        }

        fun onFailure(error: String?) {
            setLoadingState(false)

            Toast.makeText(
                application.applicationContext,
                "There was an error: $error", Toast.LENGTH_LONG
            ).show()
        }

        firebaseRepository.addOrders(
            orderList = list,
            onSuccess = ::onSuccess,
            onFailure = ::onFailure
        )
    }
}