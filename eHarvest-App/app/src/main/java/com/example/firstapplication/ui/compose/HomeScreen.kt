package com.example.firstapplication.ui.compose


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
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
fun cardItem()
{
    Card {
        Row() {
            Text(
                text = "Jetpack"
            )
//            Spacer(modifier = Modifier.pre(8.dp))
            Text(
                text = "Compose"
            )
        }
    }
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

        cardItem()

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    FirstApplicationTheme {

    }
}