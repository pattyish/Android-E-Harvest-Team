package com.example.firstapplication.ui.compose

sealed class Screen(val route: String) {
    object First: Screen(route = "first_screen")
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
    object Dashboard: Screen(route = "dashboard_screen")
}
