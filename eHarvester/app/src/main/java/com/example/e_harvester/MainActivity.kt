package com.example.e_harvester

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.e_harvester.ui.theme.Lab_4Theme
import com.example.e_harvester.ui.theme.TaskTheme
import com.example.e_harvester.ui.theme.compose.navigation.BottomNavigationDesign
import com.example.e_harvester.ui.theme.compose.navigation.NavigationSetup


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         ScreenSetup()
        }
    }
}

@Composable
fun ScreenSetup()
{
    TaskTheme() {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomNavigationDesign(navController) }
            ) {
                NavigationSetup(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab_4Theme {
        ScreenSetup()
    }
}