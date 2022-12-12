package com.eharvest.cmu.navigation

import com.eharvest.cmu.R

sealed class BottomBarScreen(val title: String, val icon: Int, val route: String) {
    object Home : BottomBarScreen(
        title = "Home",
        icon = R.drawable.home,
        route = "home"
    )

    object Cart : BottomBarScreen(
        title = "Cart",
        icon = R.drawable.cart,
        route = "cart"
    )

    object Favourite : BottomBarScreen(
        title = "Favourite",
        icon = R.drawable.heart,
        route = "favourite"
    )

    object Profile : BottomBarScreen(
        title = "Profile",
        icon = R.drawable.profile,
        route = "profile"
    )
}
