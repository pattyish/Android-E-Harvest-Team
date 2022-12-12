package com.eharvest.cmu

import NavigationGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import com.eharvest.cmu.presentaion.detail_screen.DetailViewModel
import com.eharvest.cmu.presentaion.signin_screen.OneTapSignInViewModel
import com.eharvest.cmu.ui.theme.JetBeeTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val productDetailViewModel = viewModels<DetailViewModel>()
    private val oneTapSignInViewModel = viewModels<OneTapSignInViewModel>()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EHarvestTheme {
                val navController = rememberAnimatedNavController()

                NavigationGraph(
                    navController = navController,
                    detailViewModel = productDetailViewModel.value,
                    oneTapSignInViewModel = oneTapSignInViewModel.value
                )
            }
        }
    }
}

