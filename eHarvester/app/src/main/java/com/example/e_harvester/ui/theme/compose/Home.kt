package com.example.e_harvester.ui.theme.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.e_harvester.R
import com.example.e_harvester.ui.theme.*

@Composable
fun newsButton(navController: NavController)
{
    Button(onClick = { navController.navigate("news_screen") }) {
        Text(text = stringResource(id = R.string.news_check), modifier = Modifier.padding(top = 20.dp,start=70.dp, end = 70.dp, bottom = 20.dp), fontSize = 20.sp)
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .verticalScroll(rememberScrollState())
        .fillMaxWidth()
        .padding(20.dp)) {
        Card(
        elevation = 50.dp, modifier = Modifier.align(CenterHorizontally)

        ) {
        Image(painter = painterResource(id = R.drawable.cover2), contentDescription = null)
        Column(modifier = Modifier
            .padding(start = 18.dp, top = 60.dp)
            .background(
                color = coverColor,
                shape = MaterialTheme.shapes.medium
            )) {
        Text(text = stringResource(id = R.string.welcome_msg), style = MaterialTheme.typography.h6,color = Color.White,textAlign = TextAlign.Center, modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 5.dp, end = 5.dp))

        }
            Column(modifier = Modifier
                .padding(top = 135.dp, start = 0.dp)
                .fillMaxWidth()
                .height(115.dp)
                .background(
                    coverColor2, shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                )
                .padding(30.dp)) {
                Column() {
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//                        Text(text = stringResource(id = R.string.veg), style = MaterialTheme.typography.body1, color = Color.White, modifier = Modifier
//                            .padding(15.dp)
//                            .background(blueColor, shape = RoundedCornerShape(10.dp)), fontSize = 12.sp)
                        Button(onClick = { /*TODO*/ }, border = BorderStroke(2.dp, color = Color.White), modifier = Modifier.padding(3.dp)) {

                            Text(text = stringResource(id = R.string.veg),style = MaterialTheme.typography.body2)
                        }

                        Button(onClick = { /*TODO*/ }, border = BorderStroke(2.dp, color = Color.White), modifier = Modifier.padding(3.dp)) {
                            Text(text = "Fruits",style = MaterialTheme.typography.body2)
                        }
                        Button(onClick = { /*TODO*/ }, border = BorderStroke(2.dp, color = Color.White), modifier = Modifier.padding(3.dp)) {
                            Text(text = "Grains", style = MaterialTheme.typography.body2)
                        }
                        Button(onClick = { /*TODO*/ }, border = BorderStroke(2.dp, color = Color.White), modifier = Modifier.padding(3.dp)) {
                            Text(text = "Seeds", style = MaterialTheme.typography.body2)
                        }
                    }

                }

            }
            }





Column(modifier = Modifier.padding(bottom = 45.dp)) {


        Column(modifier = Modifier
            .padding(top = 12.dp, bottom = 10.dp)
            .fillMaxWidth()) {
            Text(text = "Vegetables", color = Color.Black, modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 15.dp), fontSize = 20.sp)
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                   Column(
                       modifier = Modifier.padding(top = 5.dp)
                       ) {
                       Image(modifier = Modifier
                           .height(80.dp)
                           .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                       Column(modifier = Modifier
                           .padding(top = 12.dp)
                           .background(yellowColor)
                           .padding(10.dp)
                           .width(80.dp)) {
                           Text(text = "12 $",fontSize = 18.sp)
                           Text(text = "Leafy Green", fontSize = 14.sp)
                       }
                   }
                }


                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }



                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }

                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }
            }
            Text(text = "View more...", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(start = 12.dp,top=3.dp))
        }


        Column(modifier = Modifier
            .padding(top = 12.dp, bottom = 10.dp)
            .fillMaxWidth()) {
            Text(text = "Grains", color = Color.Black, modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 15.dp), fontSize = 20.sp)
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.apple), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }


                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.apple), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }



                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.apple), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }

                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.apple), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }
            }
            Text(text = "View more...", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(start = 12.dp,top=3.dp))
        }


        Column(modifier = Modifier
            .padding(top = 12.dp, bottom = 10.dp)
            .fillMaxWidth()) {
            Text(text = "Fruits", color = Color.Black, modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 15.dp), fontSize = 20.sp)
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }


                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }



                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }

                Card(elevation = 50.dp, modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Column(
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Image(modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),painter = painterResource(id = R.drawable.cab_1), contentDescription = null)
                        Column(modifier = Modifier
                            .padding(top = 12.dp)
                            .background(yellowColor)
                            .padding(10.dp)
                            .width(80.dp)) {
                            Text(text = "12 $",fontSize = 18.sp)
                            Text(text = "Leafy Green", fontSize = 14.sp)
                        }
                    }
                }
            }
            Text(text = "View more...", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(start = 12.dp,top=3.dp))
        }





}
    }
}