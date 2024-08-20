package com.octochimp.phonefinder3.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.octochimp.phonefinder3.R
import com.octochimp.phonefinder3.data.settings_items.SettingItem
import com.octochimp.phonefinder3.data.settings_items.settingItems
import com.octochimp.phonefinder3.ui.theme.PhoneFinder3Theme
import com.octochimp.phonefinder3.ui.theme.gradientBackground


@Composable
fun ProfileScreen(parentNavController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                brush = gradientBackground
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(75.dp))
                        .size(150.dp),
                    painter = painterResource(R.drawable.profile_pic),
                    contentDescription = null
                )
                Text(text = "Shashika Lakshan")
                Text(text = "shashika2000@gmail.com")
            }
            Card(
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .padding(16.dp)


            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    settingItems.forEach {
                        SettingItem(it, parentNavController)
                    }
                }

            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfile() {
    PhoneFinder3Theme {
        //ProfileScreen()
    }

}


@Composable
fun SettingItem(settingItem: SettingItem, parentNavController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    Log.d("shashika", "Row Clicked")
                    settingItem.onSettingItemClicked(parentNavController)
                }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = settingItem.icon, contentDescription = null
        )
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = settingItem.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = settingItem.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}