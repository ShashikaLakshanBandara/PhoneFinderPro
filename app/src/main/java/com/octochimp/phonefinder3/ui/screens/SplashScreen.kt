package com.octochimp.phonefinder3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.octochimp.phonefinder3.R
import com.octochimp.phonefinder3.data.navigation_items.NavigationRoutes
import com.octochimp.phonefinder3.ui.theme.gradientBackground
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier:Modifier = Modifier,parentNavController:NavHostController){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = gradientBackground
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                modifier = Modifier.size(350.dp),
                painter = painterResource(id = R.drawable.find_boy), contentDescription = "BoyLogo"
            )
            Text(
                text = "Phone Finder",
                modifier = Modifier
                    .padding(bottom = 70.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )

        }
    }
    LaunchedEffect(key1 = 1) {
        delay(500)
        parentNavController.navigate(NavigationRoutes.main_home_screen.toString()){
            popUpTo(NavigationRoutes.splash_screen.toString()) { inclusive = true }
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview(){
    //SplashScreen(parentNavController = NavHostController())
}
