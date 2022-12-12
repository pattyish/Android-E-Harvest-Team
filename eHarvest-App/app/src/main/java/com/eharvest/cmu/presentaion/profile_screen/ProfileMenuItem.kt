package com.eharvest.cmu.presentaion.profile_screen

data class ProfileMenuItem(
    val name: String,
    val icon: Int,
    val actionIcon: Int? = null,
    val route: String
)
