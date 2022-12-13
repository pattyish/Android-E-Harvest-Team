package com.eharvest.cmu.presentaion.add_product

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddProductScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "Add Product",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                })
        }, content = {
            Column(
                Modifier.padding(20.dp, 70.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                val name = remember { mutableStateOf(TextFieldValue()) }
                val description = remember { mutableStateOf(TextFieldValue()) }
                val category = remember { mutableStateOf(TextFieldValue()) }
                val price = remember { mutableStateOf(TextFieldValue()) }
                val tag = remember { mutableStateOf(TextFieldValue()) }

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Name") },
                    value = name.value,
                    onValueChange = { name.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Description") },
                    value = description.value,
                    onValueChange = { description.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Category") },
                    value = category.value,
                    onValueChange = { category.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Price") },
                    value = price.value,
                    onValueChange = { price.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Tag") },
                    value = tag.value,
                    onValueChange = { tag.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Box(modifier = Modifier.padding(30.dp)) {
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Create Product")
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun PrevPage() {
//    AddProductScreen()
}