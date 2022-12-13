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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun SeedsChanger():String
{  var nameCategory by rememberSaveable() { mutableStateOf("") }
    Button(onClick = { nameCategory="Seeds" }, modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .clip(
            RoundedCornerShape(100.dp)
        )) {
        Text(text = "Seeds")
    }
   return nameCategory
}

@Composable
fun VegetablesChanger():String
{  var nameCategory by rememberSaveable() { mutableStateOf("") }
    Button(onClick = { nameCategory="Vegetables" }, modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .clip(
            RoundedCornerShape(100.dp)
        )) {
        Text(text = "Vegetables")
    }
    return nameCategory
}

@Composable
fun FruitsChanger():String
{  var nameCategory by rememberSaveable() { mutableStateOf("") }
    Button(onClick = { nameCategory="Fruits" }, modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .clip(
            RoundedCornerShape(100.dp)
        )) {
        Text(text = "Fruits")
    }
    return nameCategory
}

@Composable
fun GrainsChanger():String
{  var nameCategory by rememberSaveable() { mutableStateOf("") }
    Button(onClick = { nameCategory="Grains" }, modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .clip(
            RoundedCornerShape(100.dp)
        )) {
        Text(text = "Grains")
    }
    return nameCategory
}


@Composable
fun RootChanger():String
{  var nameCategory by rememberSaveable() { mutableStateOf("") }
    Button(onClick = { nameCategory="Roots" }, modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .clip(
            RoundedCornerShape(100.dp)
        )) {
        Text(text = "Roots")
    }
    return nameCategory
}@Composable
fun AllChanger():String
{  var nameCategory by rememberSaveable() { mutableStateOf("") }
    Button(onClick = { nameCategory="All" }, modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .clip(
            RoundedCornerShape(100.dp)
        )) {
        Text(text = "All")
    }
    return nameCategory
}





@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    userViewModel: UserViewModel = hiltViewModel(),
    navController: NavHostController,
    detailViewModel: DetailViewModel,
) {
    val state = viewModel.getAllproducts.collectAsState()

    var nameCategory by rememberSaveable() { mutableStateOf("") }
    var seeds by rememberSaveable() { mutableStateOf("") }
    var fruits by rememberSaveable() { mutableStateOf("") }
    var veg by rememberSaveable() { mutableStateOf("") }
    var grains by rememberSaveable() { mutableStateOf("") }
    var all by rememberSaveable(){ mutableStateOf("") }
    var roots by rememberSaveable() { mutableStateOf("") }
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
                        name = "Search",
                        icon = com.eharvest.cmu.R.drawable.baseline_search_24,
                        route = Screens.SearchScreen.route
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
                            Text(text = "Category", fontSize = 12.sp, modifier = Modifier.padding(bottom = 5.dp))
                            nameCategory = "All"
                            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//                                Button(onClick = { nameCategory="All" }, modifier = Modifier
//                                    .padding(start = 5.dp, end = 5.dp)
//                                    .clip(
//                                        RoundedCornerShape(100.dp)
//                                    )) {
//                                    Text(text = "All")
//                                }
                                all = AllChanger()
                                seeds = SeedsChanger()
                                veg = VegetablesChanger()
                                grains = GrainsChanger()
                                fruits = FruitsChanger()
                                roots = RootChanger()

                                if (seeds.length>0)
                                {
                                    nameCategory = seeds
                                }
                                if (fruits.length>0)
                                {
                                    nameCategory = fruits
                                }
                                if (all.length>0)
                                {
                                    nameCategory = all
                                }
                                if (veg.length>0)
                                {
                                    nameCategory = veg
                                }
                                if (grains.length>0)
                                {
                                    nameCategory = grains

                                }
                                if (roots.length>0)
                                {
                                    nameCategory = roots
                                }


//                                Button(onClick = { nameCategory="Vegetables" }, modifier = Modifier
//                                    .padding(start = 5.dp, end = 5.dp)
//                                    .clip(
//                                        RoundedCornerShape(100.dp)
//                                    )) {
//                                    Text(text = "Vegetables")
//                                }
//                                Button(onClick = { nameCategory="Grains" }, modifier = Modifier
//                                    .padding(start = 5.dp, end = 5.dp)
//                                    .clip(
//                                        RoundedCornerShape(100.dp)
//                                    )) {
//                                    Text(text = "Grains")
//                                }
//                                Button(onClick = { nameCategory="Fruits" }, modifier = Modifier
//                                    .padding(start = 5.dp, end = 5.dp)
//                                    .clip(
//                                        RoundedCornerShape(100.dp)
//                                    )) {
//                                    Text(text = "Fruits")
//                                }
//                                Button(onClick = { nameCategory="Roots" }, modifier = Modifier
//                                    .padding(start = 5.dp, end = 5.dp)
//                                    .clip(
//                                        RoundedCornerShape(100.dp)
//                                    )) {
//
//                                    Text(text = "Roots")
//                                }
                            }
                            Row() {
                                Text(text = nameCategory, fontSize = 12.sp, modifier = Modifier.padding(bottom = 5.dp, end = 3.dp))
                                Text(text = "Products", fontSize = 12.sp, modifier = Modifier.padding(bottom = 5.dp))
                            }

                        }
                        if (state.value.productSuccess?.isNotEmpty() == true) {
                            if(nameCategory.equals("All"))
                            {
                                AllProductContent(
                                    product = state.value.productSuccess!!,
                                    navController = navController,
                                    detailViewModel = detailViewModel
                                )
                            }
                            if(nameCategory.equals("Seeds"))
                            {
                                SeedsProducts(
                                    product = state.value.productSuccess!!,
                                    navController = navController,
                                    detailViewModel = detailViewModel)
                                nameCategory = seeds
                            }
                            if(nameCategory.equals("Fruits"))
                            {
                                FruitsProducts(
                                    product = state.value.productSuccess!!,
                                    navController = navController,
                                    detailViewModel = detailViewModel)
                                nameCategory = seeds
                            }
                            if(nameCategory.equals("Vegetables"))
                            {
                                VegetablesProducts(
                                    product = state.value.productSuccess!!,
                                    navController = navController,
                                    detailViewModel = detailViewModel)
                                nameCategory = seeds
                            }
                            if(nameCategory.equals("Grains"))
                            {
                                GrainsProducts(
                                    product = state.value.productSuccess!!,
                                    navController = navController,
                                    detailViewModel = detailViewModel)
                                nameCategory = seeds
                            }
                            if(nameCategory.equals("Roots"))
                            {
                                RootsProducts(
                                    product = state.value.productSuccess!!,
                                    navController = navController,
                                    detailViewModel = detailViewModel)
                                nameCategory = seeds
                            }

                        }
                    }
                }
            }
        })
}

