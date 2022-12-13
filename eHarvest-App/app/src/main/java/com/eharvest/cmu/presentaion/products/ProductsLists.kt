package com.eharvest.cmu.presentaion.products

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.eharvest.cmu.R
import com.eharvest.cmu.navigation.Screens
import com.eharvest.cmu.presentaion.cart_screen.components.AppTopBar
import com.eharvest.cmu.presentaion.cart_screen.components.CartBillItem
import kotlinx.serialization.json.JsonNull.content

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductsLitScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(backgroundColor = Color.Black,
                    title = {
                        Text(
                            text = "Products",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate(Screens.AddProduct.route) }) {
                    Icon(Icons.Filled.Add, contentDescription = "")
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                )
                {
                    ProductItem()
                    ProductItem()
                }

            })
    }
}

@Composable
fun ProductItem() {
    val imageModifier = Modifier
        .size(100.dp)
        .padding(10.dp)
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .padding(10.dp)
    ) {
        Row{
            Column {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Fit,
                    modifier = imageModifier,
                )
            }
            Column(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Desc")
                Text(text = "100Kg")
            }
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
//    ProductsLitScreen(navController = NavController)
}