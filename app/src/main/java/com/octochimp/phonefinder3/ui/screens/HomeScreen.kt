package com.octochimp.phonefinder3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.octochimp.phonefinder3.R
import com.octochimp.phonefinder3.ui.theme.gradientBackground


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .background(
                brush = gradientBackground
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .size(300.dp)
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.robo),
                    contentDescription = "Robot"
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.Home_Title),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold

                    )
                )
                Text(
                    text = "Basic Functions works without the internet, Only nee a SIM. The Command can be send through the text Messages",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        top = 16.dp,
                        end = 8.dp,
                        start = 8.dp,
                        bottom = 16.dp
                    ),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White,

                        )
                )
            }


        }

    }


}






@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    //HomeScreen()
}