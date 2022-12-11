package com.example.e_harvester.ui.theme.compose.navigation

sealed class ScreenDestinations(val route: String) {
    object Home : ScreenDestinations("home_screen")
    object News : ScreenDestinations("news_screen")
    object Settings : ScreenDestinations("settings_screen")
    object Todo : ScreenDestinations("todo_screen")
    object Login : ScreenDestinations("login_screen")
    object Register : ScreenDestinations("register_screen")
    object Forget : ScreenDestinations("forget_screen")
    object Reset : ScreenDestinations("reset_screen")
    object Checkout : ScreenDestinations("checkout_screen")
}