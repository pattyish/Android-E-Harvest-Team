package com.eharvest.cmu.presentaion.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.eharvest.cmu.domain.model.CartProducts
import com.eharvest.cmu.domain.model.Product
import com.eharvest.cmu.navigation.Screens
import com.eharvest.cmu.presentaion.cart_screen.CoffeeCartViewModel
import com.eharvest.cmu.presentaion.common.RegularFont
import com.eharvest.cmu.presentaion.common.UserViewModel
import com.eharvest.cmu.presentaion.detail_screen.DetailViewModel
import com.eharvest.cmu.ui.theme.LightBlack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.eharvest.cmu.R


@Composable
fun AllCoffeeContent(
    product: List<Product>,
    navController: NavController,
    detailViewModel: DetailViewModel
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(130.dp),
        content = {
            items(product.size) { i ->
                CoffeeCard(product = product[i], navController = navController, detailViewModel = detailViewModel)
            }
        })

}


@Composable
fun CoffeeCard(
    product: Product,
    userViewModel: UserViewModel = hiltViewModel(),
    coffeeCartViewModel: CoffeeCartViewModel = hiltViewModel(),
    detailViewModel: DetailViewModel  ,
    navController: NavController,
) {

    Card(
        modifier = Modifier
            .height(270.dp)
            .padding(6.dp)
            .clickable {
                detailViewModel.setProduct(product)
                navController.navigate(Screens.Details.route)
            }
            .width(213.dp), backgroundColor = if (isSystemInDarkTheme()) LightBlack else LightBlack,
        shape = RoundedCornerShape(25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(100.dp)
                    .width(100.dp),
                painter = rememberAsyncImagePainter(
                    model = product.image,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Coffee"
            )
            Text(
                modifier = Modifier.padding(top = 28.dp),
                text = product.name,
                fontFamily = RegularFont,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp, color = Color.White,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                modifier = Modifier.padding(top = 3.dp),
                text = product.tagline,
                fontFamily = RegularFont,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp, color = Color.LightGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${product.price}",
                    fontFamily = RegularFont,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp, color = Color.White
                )
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            addToCart(
                                userViewModel = userViewModel,
                                coffeeCartViewModel = coffeeCartViewModel,
                                product = product
                            )

                        }
                        .clip(shape = CircleShape)
                        .background(Color.White), contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter  = painterResource(id = R.drawable.cart),
                        contentDescription = "Filter Icon", tint = Color.Black
                    )

                }
            }
        }
    }
}


fun addToCart(
    userViewModel: UserViewModel,
    coffeeCartViewModel: CoffeeCartViewModel,
    product: Product
) {
    val doesProductAlreadyExits =
        userViewModel.userState.value.cartProducts.find {
            it.productName == product.name
        }
    CoroutineScope(Dispatchers.IO).launch {
        if (doesProductAlreadyExits == null) {
            coffeeCartViewModel.addCoffeeToCart(
                cartProduct = CartProducts(
                    productName = product.name,
                    productPrice = product.price,
                    productImageUrls = product.image,
                )
            )
            userViewModel.updateUserData()
        }

    }
}


/*
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Previewcard() {
    CoffeeCard(product = Product())

}*/
