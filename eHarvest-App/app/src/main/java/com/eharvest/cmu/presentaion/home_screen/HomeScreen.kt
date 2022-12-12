package com.eharvest.cmu.presentaion.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.eharvest.cmu.navigation.BottomNavItem
import com.eharvest.cmu.navigation.BottomNavigationBar
import com.eharvest.cmu.navigation.Screens
import com.eharvest.cmu.presentaion.common.UserViewModel
import com.eharvest.cmu.presentaion.detail_screen.DetailViewModel
import com.eharvest.cmu.presentaion.home_screen.components.SearchBox
import com.eharvest.cmu.presentaion.home_screen.components.TopBar
import com.eharvest.cmu.presentaion.menu_screen.DrawerBody
import com.eharvest.cmu.presentaion.menu_screen.DrawerHeader
import com.eharvest.cmu.presentaion.menu_screen.MenuItem
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    userViewModel: UserViewModel = hiltViewModel(),
    navController: NavHostController,
    detailViewModel: DetailViewModel,
) {
    val state = viewModel.getAllCoffee.collectAsState()


    val state2 = userViewModel.userState.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    Scaffold(scaffoldState = scaffoldState, backgroundColor = Color.Black,
        topBar = {
            TopBar(onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })

        }, drawerGesturesEnabled = scaffoldState.drawerState.isOpen, drawerContent = {
            DrawerHeader()
            DrawerBody(items = listOf(
                MenuItem(
                    direction = "Home",
                    title = "Home",
                    contentDescription = "Go to home",
                    icon = Icons.Default.Home
                ),
                MenuItem(
                    direction = "About",
                    title = "About",
                    contentDescription = "Go to About",
                    icon = Icons.Default.Info
                ),
            ), onItemClick = {
                println("CLick on ${it.title}")
            })
        }, bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        icon = com.eharvest.cmu.R.drawable.home,
                        route = Screens.HomeScreen.route
                    ),
                    BottomNavItem(
                        name = "Cart",
                        icon = com.eharvest.cmu.R.drawable.cart,
                        route = Screens.CartScreen.route,
                        badgeCount = state2.cartProducts.size
                    ),
                    BottomNavItem(
                        name = "Favourite",
                        icon = com.eharvest.cmu.R.drawable.heart,
                        route = Screens.Favourite.route
                    ),
                    BottomNavItem(
                        name = "Profile",
                        icon = com.eharvest.cmu.R.drawable.profile,
                        route = Screens.Profile.route
                    ),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }, content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 18.dp, end = 18.dp, top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        SearchBox()
                        Spacer(modifier = Modifier.height(26.dp))
                        Column() {
                            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 5.dp, end = 5.dp).clip(
                                    RoundedCornerShape(100.dp)
                                )) {
                                    Text(text = "Seeds")
                                }
                                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 5.dp, end = 5.dp).clip(
                                    RoundedCornerShape(100.dp)
                                )) {
                                    Text(text = "Vegetables")
                                }
                                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 5.dp, end = 5.dp).clip(
                                    RoundedCornerShape(100.dp)
                                )) {
                                    Text(text = "Grains")
                                }
                                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 5.dp, end = 5.dp).clip(
                                    RoundedCornerShape(100.dp)
                                )) {
                                    Text(text = "Fruits")
                                }
                                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 5.dp, end = 5.dp).clip(
                                    RoundedCornerShape(100.dp)
                                )) {

                                    Text(text = "Roots")
                                }
                            }
                        }
                        if (state.value.coffeeSuccess?.isNotEmpty() == true) {
                            AllCoffeeContent(
                                product = state.value.coffeeSuccess!!,
                                navController = navController,
                                detailViewModel = detailViewModel
                            )
                        }
                    }
                }
            }
        })
}

