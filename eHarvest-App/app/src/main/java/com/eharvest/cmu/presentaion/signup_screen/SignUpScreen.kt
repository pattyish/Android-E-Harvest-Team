package com.eharvest.cmu.presentaion.signup_screen


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eharvest.cmu.R
import com.eharvest.cmu.domain.model.AuthUser
import com.eharvest.cmu.navigation.Screens
import com.eharvest.cmu.presentaion.common.AuthenticationField
import com.eharvest.cmu.presentaion.common.RegularFont
import com.eharvest.cmu.presentaion.signin_screen.FirebaseSignupViewModel
import com.eharvest.cmu.ui.theme.AksGreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun SignUpScreen(
    signUpViewModel: FirebaseSignupViewModel = hiltViewModel(),
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.rectangleligth),
                contentDescription = null,
                modifier = Modifier.padding(top = 150.dp)
            )
        }
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(640.dp),
        ) {
            val signUpState = signUpViewModel.signUpState.collectAsState(initial = null)

            val scope = rememberCoroutineScope()
            val context = LocalContext.current

            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var passwordVisibility by remember { mutableStateOf(false) }
            val icon = if (passwordVisibility) {
                painterResource(id = R.drawable.password_visible)
            } else {
                painterResource(id = R.drawable.password_toggle)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 15.dp),
                    text = "Register",
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    fontFamily = RegularFont,
                )
                Text(
                    text = "Create your account",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp, color = Color.Gray,
                    fontFamily = RegularFont,

                    )
                AuthenticationField(
                    text = email,
                    placeHolder = "Email",
                    isPasswordTextField = false,
                    onValueChange = { email = it },
                    errorMsg = "*Enter valid email address",
                    trailingIcon = {
                        if (email.isNotBlank()) {
                            IconButton(onClick = { email = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear Text"
                                )

                            }
                        }
                    })
                Spacer(modifier = Modifier.height(16.dp))
                AuthenticationField(
                    text = password,
                    placeHolder = "Password",
                    isPasswordTextField = !passwordVisibility,
                    onValueChange = { password = it },
                    errorMsg = "*Enter valid password",
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(
                                painter = icon,
                                contentDescription = "Visibility Icon",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(end = 20.dp, top = 10.dp),
                    text = "Forgot Password?",
                    fontWeight = FontWeight.SemiBold, color = Color.Black, fontFamily = RegularFont,

                    )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (signUpState.value?.isLoading == true) {
                        CircularProgressIndicator()
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            navController.navigate(
                                Screens.FireSignInScreen.route
                            )
                        },
                    text = "Already have an account? Login",
                    fontWeight = FontWeight.Bold, color = Color.Black, fontFamily = RegularFont
                )

                Button(
                    onClick = {
                        scope.launch(Dispatchers.Main) {
                            signUpViewModel.createUser(
                                AuthUser(
                                    email, password
                                )
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(top = 20.dp, start = 30.dp, end = 30.dp, bottom = 0.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = AksGreen,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        modifier = Modifier
                            .padding(7.dp)
                    )
                }
            }

            LaunchedEffect(key1 = signUpState.value?.error) {
                scope.launch(Dispatchers.Main) {
                    if (signUpState.value?.error?.isNotEmpty() == true) {
                        val error = signUpState.value?.error
                        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
                    }
                }
            }

            LaunchedEffect(key1 = signUpState.value?.isSignedUp) {
                if (signUpState.value?.isSignedUp?.isNotEmpty() == true) {
                    navController.popBackStack()
                    val successful = signUpState.value?.isSignedUp
                    Toast.makeText(context, successful, Toast.LENGTH_LONG).show()
                    navController.navigate(
                        Screens.HomeScreen.route
                    )
                }
            }
        }
    }
}
