package com.eharvest.cmu.presentaion.detail_screen

import com.eharvest.cmu.model.Product

data class DetailScreenState(
    val isLoading: Boolean  = false,
    val detailData: Product? = null,
    val error : String? = ""
)
