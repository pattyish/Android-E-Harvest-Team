package com.example.firstapplication

import ForgetPasswordScreen
import ResetPasswordScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapplication.ui.compose.AddingProduct
import com.example.firstapplication.ui.compose.FirstScreen
import com.example.firstapplication.ui.compose.HomeScreen
import com.example.firstapplication.ui.compose.LoginScreen
import com.example.firstapplication.ui.compose.RegisterScreen
import com.example.firstapplication.ui.theme.*

//import com.example.firstapplication.ui.theme.fonts

class MainActivity : ComponentActivity() {

//    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstApplicationTheme {
                IntentView()
            }
        }
    }
}

@Composable
fun IntentView(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "HomeScreen", builder =
     {
         composable(
             "ResetPasswordScreen", content = { ResetPasswordScreen(navController = navController) }
         )
         composable(
             "ForgetPasswordScreen", content = { ForgetPasswordScreen(navController = navController) }
         )
         composable(
             "HomeScreen", content = { HomeScreen(navController = navController) }
         )
        composable(
            "FirstScreen", content = { FirstScreen(navController = navController) }
        )
        composable(
          "LoginScreen", content = { LoginScreen(navController = navController) },
        )
        composable(
            "RegisterScreen", content = { RegisterScreen(navController = navController) }
        )
         composable(
             "AddingProduct", content = { AddingProduct(navController = navController) }
         )

     }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview1() {
    FirstApplicationTheme {

    }
}