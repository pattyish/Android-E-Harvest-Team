package com.example.e_harvester.ui.theme.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.e_harvester.R
import com.example.e_harvester.model.NewsDataModel
import com.example.e_harvester.model.newsData
import com.example.e_harvester.ui.theme.WhiteFort
import com.example.e_harvester.ui.theme.yellowColor

@Composable
fun SearchField() {
    var text by remember { mutableStateOf("Hello") }
    OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon") },
        onValueChange = { text = it },
        label = { Text("Search", fontSize = 16.sp) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 6.dp, end = 12.dp)

    )
}

@Composable
fun NewsScreen(navController: NavHostController) {
    val context = LocalContext.current

    Column {
        SearchField()



        LazyColumn(
        modifier = Modifier.padding(bottom = 50.dp),
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp)
    )
    {
        items(newsData){ news ->
            NewsItem(item = news, context)
        }
    }

    }

}

@Composable
fun NewsItem(item: NewsDataModel, context: Context) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(15.dp),
        backgroundColor = WhiteFort,
        contentColor = Color.Black,
        modifier = Modifier
            .padding(8.dp)
            .padding(bottom = 2.dp)
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(
                        context,
                        context.resources.getString(R.string.readmsg) + " " + item.title,
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(painter = painterResource(item.imgUrl), contentDescription = null,
                Modifier
                    .height(90.dp)
                    .width(90.dp))
            Column(modifier = Modifier
                .width(140.dp)
                .padding(start = 14.dp)) {
                Text(text = item.title, style = MaterialTheme.typography.body1)
                Text(text = item.desc, style = MaterialTheme.typography.h6)
                Text(text = "Fruits", style = MaterialTheme.typography.h6, color = yellowColor)
            }
            Column() {
                Box(modifier = Modifier.padding(12.dp))
                {
                    Button(onClick = { /*TODO*/ }) {
                        Column(verticalArrangement = Arrangement.Center) {
                            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "searchIcon")
                            Text(text = "Add To Cart", fontSize = 10.sp)
                        }

                    }
                }

            }

        }

    }
}
