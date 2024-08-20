package com.octochimp.phonefinder3.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    parentNavController: NavController = rememberNavController(),
    title:String,
){
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = {
                parentNavController.popBackStack()
            }){
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Back Arrow")
            }
        },
    )
}