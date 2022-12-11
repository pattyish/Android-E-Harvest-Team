package com.example.e_harvester.ui.theme.compose.navigation

import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.e_harvester.R

sealed class BottomNavItem(
    val route: String,
    @StringRes val titleResId: Int,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        route = ScreenDestinations.Home.route,
        titleResId = R.string.home,
        icon = Icons.Default.Home
    )

    object News : BottomNavItem(
        route = ScreenDestinations.News.route,
        titleResId = R.string.news,
        icon = Icons.Default.Search
    )

    object Todo : BottomNavItem(
        route = ScreenDestinations.Todo.route,
        titleResId = R.string.cart,
        icon = Icons.Default.ShoppingCart
    )

    object Settings : BottomNavItem(
        route = ScreenDestinations.Settings.route,
        titleResId = R.string.settings,
        icon = Icons.Default.AccountCircle
    )
}

@Composable
fun BottomNavigationDesign(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.News,
        BottomNavItem.Todo,
        BottomNavItem.Settings
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.titleResId)
                    )
                },
                label = { Text(text = stringResource(id = item.titleResId)) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        launchSingleTop = true

                        restoreState = true
                    }
                }
            )
        }
    }
}