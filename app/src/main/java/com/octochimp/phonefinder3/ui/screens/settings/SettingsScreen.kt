package com.octochimp.phonefinder3.ui.screens.settings

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChangeCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.octochimp.phonefinder3.R
import com.octochimp.phonefinder3.data.database.User
import com.octochimp.phonefinder3.ui.composables.MyTopAppBar
import com.octochimp.phonefinder3.ui.theme.PhoneFinder3Theme
import com.octochimp.phonefinder3.ui.theme.gradientBackground




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    parentNavController: NavHostController = rememberNavController(),
    state: SettingsState,
    onEvents: (SettingsEvents) -> Unit
) {
    var currentUser = state.user


    Scaffold(
        topBar = {
            MyTopAppBar(
                parentNavController = parentNavController,
                title = "Settings"
            )
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .padding(innerPadding)
                .background(
                    brush = gradientBackground
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .align(
                            alignment = Alignment.CenterHorizontally
                        )

                ) {
                    Image(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(75.dp))
                            .size(150.dp)
                            .border(5.dp, color = Color.White, shape = RoundedCornerShape(75.dp)),
                        painter = painterResource(id = R.drawable.profile_pic),
                        contentDescription = null
                    )
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                    ) {
                        Icon(imageVector = Icons.Rounded.ChangeCircle, contentDescription = null)
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        CardItem(heading = "User Name", value = state.userName, onValueChanged = {
                            onEvents(SettingsEvents.setUserName(it))
                        })
                        CardItem(heading = "Email Address", value = state.email, onValueChanged = {
                            onEvents(SettingsEvents.setEmail(it))
                        })
                        CardItem(
                            heading = "Security Code",
                            value = state.code,
                            onValueChanged = {
                                onEvents(SettingsEvents.setCode(it))
                            })
                        if (state.showConfirmCode) {
                            CardItem(
                                heading = "Confirm Security Code",
                                value = "",
                                onValueChanged = {})
                        }

                        CardItem(
                            heading = "Backup Phone Number",
                            value = state.phone,
                            onValueChanged = {
                                onEvents(SettingsEvents.setPhone(it))
                            })

                    }
                }
                Button(
                    onClick = {
                        onEvents(SettingsEvents.SaveUser)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Save")
                }
            }
        }

    }


}


@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    heading: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text = heading)
        OutlinedTextField(value = value, onValueChange = onValueChanged)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsPreview() {
    PhoneFinder3Theme {
        //SettingsScreen()
    }

}