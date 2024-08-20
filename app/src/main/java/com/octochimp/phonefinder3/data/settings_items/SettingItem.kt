package com.octochimp.phonefinder3.data.settings_items

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

data class SettingItem(
    val title:String,
    val description:String,
    val icon: ImageVector,
    val onSettingItemClicked:(parentNavController:NavHostController)->Unit
)
