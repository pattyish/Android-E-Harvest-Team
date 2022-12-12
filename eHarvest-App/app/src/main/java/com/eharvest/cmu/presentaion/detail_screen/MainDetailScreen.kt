package com.eharvest.cmu.presentaion.detail_screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainDetailScreen(
    detailViewModel: DetailViewModel,
    navController: NavController,
) {
    val productDetail = detailViewModel.product.value

    DetailScreen(product = productDetail, navController = navController)
}
