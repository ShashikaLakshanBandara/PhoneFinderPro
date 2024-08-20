package com.octochimp.phonefinder3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.PhoneAndroid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.octochimp.phonefinder3.ui.theme.gradientBackground

@Composable
fun FindScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = gradientBackground
            ),
        Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "Connect to the phone",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Phone Number")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Rounded.PhoneAndroid, contentDescription = null)
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "PIN Number")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Rounded.Password, contentDescription = null)
                    }
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    textAlign = TextAlign.Center,
                    text = "Please Enter Your lost device's phone number and the security code"
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Check"
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewF() {
    //FindScreen()
}