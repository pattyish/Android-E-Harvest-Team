package com.example.firstapplication.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapplication.R
import com.example.firstapplication.ui.theme.*

@Composable
fun AddingProduct(navController: NavController){
    Column(){
        TopAppBar(
            title = { Text("Simple TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            },
            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                }
            }
        )
        Box() {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(640.dp),
            ) {
                Text(
                    text = "Add Product",
                    fontFamily = aksfonts,
                    style = TextStyle(fontSize = 45.sp),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 30.dp, top = 40.dp)
                )
                Spacer(modifier = Modifier.padding(top = 7.dp))
                Text(
                    text = "Product Name",
                    fontFamily = karla,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier
                        .padding(start = 30.dp),
                    color = TextGray
                )
                var name by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    value = name,
                    onValueChange = { newText -> name = newText },
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .fillMaxWidth()
                        .background(AkshatWhite),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black
                    ),
                    shape = RoundedCornerShape(0.5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Text(
                    text = "Product description",
                    fontFamily = karla,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier
                        .padding(start = 30.dp),
                    color = TextGray
                )
                var description by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    value = description,
                    onValueChange = { newText -> description = newText },
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .fillMaxWidth()
                        .background(AkshatWhite),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black
                    ),
                    shape = RoundedCornerShape(0.5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Text(
                    text = "Quantity",
                    fontFamily = karla,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier
                        .padding(start = 30.dp),
                    color = TextGray
                )
                var quantity by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(value = quantity,
                    onValueChange = { newText -> quantity = newText },
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .fillMaxWidth()
                        .background(AkshatWhite),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black
                    ),
                    shape = RoundedCornerShape(0.5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    maxLines = 1,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Text(
                    text = "Price",
                    fontFamily = karla,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier
                        .padding(start = 30.dp),
                    color = TextGray
                )
                var price by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(value = price,
                    onValueChange = { newText -> price = newText },
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .fillMaxWidth()
                        .background(AkshatWhite),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black
                    ),
                    shape = RoundedCornerShape(0.5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    maxLines = 1,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null
                        )
                    }
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = AksGreen)
                ) {
                    Text(
                        text = "Add Product",
                        color = Color.White,
                        style = TextStyle(fontSize = 23.sp),
                        modifier = Modifier
                            .background(color = AksGreen)
                            .padding(top = 1.dp),
                        fontFamily = karla,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}