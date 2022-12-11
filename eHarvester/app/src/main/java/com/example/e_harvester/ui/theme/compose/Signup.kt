package com.example.e_harvester.ui.theme.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_harvester.R
import com.example.e_harvester.ui.theme.*
import com.example.e_harvester.ui.theme.compose.navigation.ScreenDestinations

@Composable
fun RegisterScreen (navController: NavController){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = R.drawable.rectangleligth),
                contentDescription = null,
                modifier = Modifier.padding(top = 150.dp)
            )
        }

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(640.dp),
        ){
            Text(text = "Register",
                fontFamily = aksfonts,
                style = TextStyle(fontSize = 45.sp),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 30.dp, top = 40.dp)
            )
            Spacer(modifier = Modifier.padding(top = 7.dp))
            Text(text = "Welcome!",
                fontFamily = karla,
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .padding(start = 30.dp),
                color = TextGray
            )
            Text(text = "Create your account",
                fontFamily = karla,
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .padding(start = 30.dp),
                color = TextGray
            )
            Spacer(modifier = Modifier.padding(top = 45.dp))
            Text(text = "YOUR NAME",
                fontFamily = karla,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier
                    .padding(start = 30.dp),
                color = TextGray
            )
            var name by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(value = name,
                onValueChange = { newText -> name = newText},
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
            Text(text = "EMAIL",
                fontFamily = karla,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier
                    .padding(start = 30.dp),
                color = TextGray
            )
            var email by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(value = email,
                onValueChange = { newText -> email = newText},
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
            Text(text = "PASSWORD",
                fontFamily = karla,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier
                    .padding(start = 30.dp),
                color = TextGray
            )
            var password by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(value = password,
                onValueChange = { newText -> password = newText},
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
                trailingIcon = { Icon(imageVector = Icons.Default.Settings, contentDescription = null) }
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(text = "I have an account",
                fontFamily = karla,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 120.dp)
                    .clickable { navController.navigate(ScreenDestinations.Login.route) },
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(onClick = { navController.navigate(ScreenDestinations.Login.route) },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = AksGreen)
            ) {
                Text(text = stringResource(id = R.string.register_button),
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