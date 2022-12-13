
package com.eharvest.cmu.presentaion.signin_screen

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.res.stringResource
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
import com.eharvest.cmu.ui.theme.AksGreen
import com.eharvest.cmu.util.Constant.SERVER_CLIENT_ID
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(
    oneTapSignInViewModel: OneTapSignInViewModel,
    signInViewModel: FirebaseSingInViewModel = hiltViewModel(),
    navController: NavController,
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
        ){
        val googleState = oneTapSignInViewModel.googleSingInState.collectAsState()
        val launcher =
            rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
                val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                try {
                    val result = account.getResult(ApiException::class.java)
                    val credentials = GoogleAuthProvider.getCredential(result.idToken!!, null)
                    oneTapSignInViewModel.signInWithGoogleCredentials(
                        credentials,
                        user = AuthUser()
                    )
                } catch (it: ApiException) {
                    print(it)
                }
            }

        val signInState = signInViewModel.signInState.collectAsState(initial = null)
        val scope = rememberCoroutineScope()
        val context = LocalContext.current
        val isUserExist = signInViewModel.currentUserExist.collectAsState(initial = true)
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        val icon = if (passwordVisibility) {
            painterResource(id = R.drawable.password_visible)
        } else {
            painterResource(id = R.drawable.password_toggle)
        }

        LaunchedEffect(key1 = Unit) {
            if (isUserExist.value) {
                navController.popBackStack()
                navController.navigate(
                    Screens.HomeScreen.route
                )
            }
        }

        if (!isUserExist.value) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 15.dp),
                    text = stringResource(id = R.string.login),
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    fontFamily = RegularFont,
                )
                Text(
                    text = "Log in to Continue",
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
                    text = stringResource(id = R.string.forgot_password),
                    fontWeight = FontWeight.SemiBold, color = Color.Black, fontFamily = RegularFont,

                    )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (signInState.value?.isLoading == true) {
                        CircularProgressIndicator()
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            navController.navigate(
                                Screens.FireSignUpScreen.route
                            )
                        },
                    text = "Don't have an account? sign up",
                    fontWeight = FontWeight.Bold, color = Color.Black, fontFamily = RegularFont
                )
                Column(
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
                            scope.launch(Dispatchers.Main) {
                                signInViewModel.loginUser(
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
                            backgroundColor= AksGreen,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_in_button),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(7.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (googleState.value.isLoading == true) {
                        CircularProgressIndicator()
                    }
                }

            }


            LaunchedEffect(key1 = signInState.value?.error) {
                scope.launch(Dispatchers.Main) {
                    if (signInState.value?.error?.isNotEmpty() == true) {
                        val error = signInState.value?.error
                        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
                    }
                }
            }

            LaunchedEffect(key1 = signInState.value?.isSignedIn) {
                if (signInState.value?.isSignedIn?.isNotEmpty() == true) {
                    navController.popBackStack()
                    val successful = signInState.value?.isSignedIn
                    Toast.makeText(context, successful, Toast.LENGTH_LONG).show()
                    navController.navigate(
                        Screens.HomeScreen.route
                    )
                }
            }

            LaunchedEffect(key1 = googleState.value.success) {
                if (googleState.value.success != null) {
                    // navController.popBackStack()
                    navController.navigate(
                        Screens.HomeScreen.route
                    )
                    val successful = googleState.value.success.toString()
                    Toast.makeText(context, "successful", Toast.LENGTH_LONG).show()

                }
            }

        }
    }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun PrevSignInScreen() {
    SignInScreen(navController = NavHostController(LocalContext.current))
}*/
