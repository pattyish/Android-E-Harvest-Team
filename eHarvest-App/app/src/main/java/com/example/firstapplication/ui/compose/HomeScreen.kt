package com.example.firstapplication.ui.compose


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapplication.R
import com.example.firstapplication.ui.theme.*


@Composable
fun CombinedTabWithCustomIndicator() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "NEW" to Icons.Filled.Info,
        "CATEGORIES" to Icons.Filled.Build,
        "CART" to Icons.Filled.ShoppingCart,
//        "BOOKS" to Icons.Filled.Settings,
    )
    Column() {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.White,
            contentColor = Color.Black,
            divider = {
                TabRowDefaults.Divider(
                    thickness = 2.dp,
                    color = Color.White
                )
            },
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.customTabIndicatorOffset(tabPositions[tabIndex]),
                    height = 5.dp,
                    color = Color.Gray
                )
            }
        ) {
            tabData.forEachIndexed { index, pair ->
                Tab(selected = tabIndex == index, onClick = {
                    tabIndex = index
                }, text = {
                    Text(text = pair.first)
                }, icon = {
                    Icon(imageVector = pair.second, contentDescription = null)
                })
            }
        }
//        when (tabIndex) {
//            0 -> {
//                NewTab()
//            }
//            1 -> {
//                CategoriesTab()
//            }
//            2 -> {
//                CartTab()
//            }
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16", "Item 17", "Item 18", "Item 19", "Item 20", "Item 21", "Item 22", "Item 23", "Item 24", "Item 25", "Item 26", "Item 27", "Item 28", "Item 29", "Item 30", "Item 31", "Item 32", "Item 33", "Item 34", "Item 35", "Item 36", "Item 37", "Item 38", "Item 39", "Item 40", "Item 41", "Item 42", "Item 43", "Item 44", "Item 45", "Item 46", "Item 47", "Item 48", "Item 49", "Item 50", "Item 51", "Item 52", "Item 53", "Item 54", "Item 55", "Item 56", "Item 57", "Item 58", "Item 59", "Item 60", "Item 61", "Item 62", "Item 63", "Item 64", "Item 65", "Item 66", "Item 67", "Item 68", "Item 69", "Item 70", "Item 71", "Item 72", "Item 73", "Item 74", "Item 75", "Item 76", "Item 77", "Item 78", "Item 79", "Item 80", "Item 81", "Item 82", "Item 83", "Item 84", "Item 85", "Item 86", "Item 87", "Item 88", "Item 89", "Item 90", "Item 91", "Item 92", "Item 93", "Item 94", "Item 95", "Item 96", "Item 97", "Item 98", "Item 99" )
        val items2 = listOf("Item 24", "Item 25", "Item 26", "Item 27", "Item 28", "Item 29", "Item 30", "Item 31", "Item 32", "Item 33", "Item 34", "Item 35", "Item 36", "Item 37", "Item 38", "Item 39", "Item 40", "Item 41", "Item 42", "Item 43", "Item 44", "Item 45", "Item 46", "Item 47", "Item 48", "Item 49", "Item 50", "Item 51", "Item 52", "Item 53", "Item 54", "Item 55", "Item 56", "Item 57", "Item 58", "Item 59", "Item 60", "Item 61", "Item 62", "Item 63", "Item 64", "Item 65", "Item 66", "Item 67", "Item 68", "Item 69", "Item 70", "Item 71", "Item 72", "Item 73", "Item 74", "Item 75", "Item 76", "Item 77", "Item 78", "Item 79", "Item 80", "Item 81", "Item 82", "Item 83", "Item 84", "Item 85", "Item 86", "Item 87", "Item 88", "Item 89", "Item 90", "Item 91", "Item 92", "Item 93", "Item 94", "Item 95", "Item 96", "Item 97", "Item 98", "Item 99" )
    val items3 = listOf("4343434", "21121")

        if (tabIndex == 0) {
            StringGrid(items = items)
        } else if (tabIndex == 1) {
            StringGrid(items = items2)
        } else if (tabIndex == 2) {
            StringGrid(items = items3)
        }
        // create a list of strings
        // pass the list to the StringGrid composable function
//        StringGrid(items = items)
    }

}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val indicatorWidth = 32.dp
    val currentTabWidth = currentTabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}


@Composable
fun HomeScreen (navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        var password by remember { mutableStateOf(TextFieldValue("")) }
        TextField(value = password,placeholder = { Text(text = "Search Products") } ,
            onValueChange = { newText -> password = newText},
            modifier = Modifier

                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth()
                .background(AkshatWhite),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black
            ),

            shape = RoundedCornerShape(1.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1,
            trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) }
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
      CombinedTabWithCustomIndicator()

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate("LoginScreen") }) {
                    /* FAB content */
                    //Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                    Text(text = "Account")
                }
            },
            isFloatingActionButtonDocked = true,
            bottomBar = {
                BottomAppBar(
                    // Defaults to null, that is, No cutout
                    cutoutShape = MaterialTheme.shapes.small.copy(
                        CornerSize(percent = 50)
                    ), backgroundColor = AksGreen

                ) {
                    /* Bottom app bar content */
                }
            }
        ) {
        }


    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StringGrid(items:List<String>)
{
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        //loop through the items and add them to the grid using the item() composable function provided by LazyVerticalGrid
        items.forEach { item ->
            item {
                Text(text = item)
            }
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    FirstApplicationTheme {

        CombinedTabWithCustomIndicator()
    }
}