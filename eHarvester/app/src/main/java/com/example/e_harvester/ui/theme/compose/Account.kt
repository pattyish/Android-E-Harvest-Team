package com.example.e_harvester.ui.theme.compose

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_harvester.R
import com.example.e_harvester.ui.theme.compose.navigation.ScreenDestinations

@Composable
fun settingsView()
{
    Column {
        IntentView()
    }
}

@Composable
fun SettingsScreen(navController: NavHostController) {

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxWidth().padding(bottom = 100.dp)) {
        settingsView()
        }
}

@Composable
fun IntentView(){
    val navController = rememberNavController()
    var status = false
    var startView = ScreenDestinations.Login.route

    if(status == true)
    {
        startView = ScreenDestinations.Reset.route
    }

    NavHost(
        navController = navController,
        startDestination = startView, builder =
        {
            composable(
                ScreenDestinations.Reset.route, content = { ResetPasswordScreen(navController = navController) }
            )
            composable(
                ScreenDestinations.Forget.route, content = { ForgetPasswordScreen(navController = navController) }
            )
            composable(
                ScreenDestinations.Login.route, content = { LoginScreen(navController = navController) },
            )
            composable(
                ScreenDestinations.Register.route, content = { RegisterScreen(navController = navController) }
            )


        }
    )
}



