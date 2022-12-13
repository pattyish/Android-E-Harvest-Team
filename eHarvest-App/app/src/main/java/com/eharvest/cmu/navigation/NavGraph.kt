import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eharvest.cmu.navigation.Screens
import com.eharvest.cmu.presentaion.add_product.AddProductScreen
import com.eharvest.cmu.presentaion.cart_screen.components.CartScreen
import com.eharvest.cmu.presentaion.detail_screen.DetailViewModel
import com.eharvest.cmu.presentaion.detail_screen.MainDetailScreen
import com.eharvest.cmu.presentaion.home_screen.HomeScreen
import com.eharvest.cmu.presentaion.products.ProductsLitScreen
import com.eharvest.cmu.presentaion.profile_screen.ProfileScreen
import com.eharvest.cmu.presentaion.signin_screen.OneTapSignInViewModel
import com.eharvest.cmu.presentaion.signin_screen.SignInScreen
import com.eharvest.cmu.presentaion.signup_screen.SignUpScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    detailViewModel: DetailViewModel,
    oneTapSignInViewModel: OneTapSignInViewModel
) {

    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.FireSignInScreen.route) {
            SignInScreen(
                navController = navController,
                oneTapSignInViewModel = oneTapSignInViewModel
            )
        }
        composable(route = Screens.FireSignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screens.Details.route) {
            Log.d("Args", it.arguments?.getString(it.toString()).toString())
            MainDetailScreen(navController = navController, detailViewModel = detailViewModel)

        }
        composable(
            route = Screens.HomeScreen.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300, easing = FastOutSlowInEasing)
                ) +
                        fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(300)) + slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(300, easing = LinearEasing)
                )
            }
        ) {
            HomeScreen(navController = navController, detailViewModel = detailViewModel)
        }
        composable(route = Screens.CartScreen.route) {
            CartScreen(navController = navController)
        }
        composable(route = Screens.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screens.Products.route) {
            ProductsLitScreen(navController = navController)
        }
        composable(route = Screens.AddProduct.route) {
            AddProductScreen(navController = navController)
        }
    }

}