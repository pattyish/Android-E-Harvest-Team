package com.example.e_harvester.ui.theme.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.e_harvester.ui.theme.compose.HomeScreen
import com.example.e_harvester.ui.theme.compose.NewsScreen
import com.example.e_harvester.ui.theme.compose.SettingsScreen
import com.example.e_harvester.ui.theme.compose.TodoScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController)
        }
        composable(ScreenDestinations.News.route) {

            NewsScreen(navController)
        }
        composable(ScreenDestinations.Todo.route) {
            TodoScreen(navController)
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen(navController)
        }

    }
}