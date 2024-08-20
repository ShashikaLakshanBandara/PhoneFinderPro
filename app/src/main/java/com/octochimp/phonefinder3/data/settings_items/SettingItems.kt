package com.octochimp.phonefinder3.data.settings_items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.SupportAgent
import com.octochimp.phonefinder3.data.navigation_items.NavigationRoutes

val settingItems = listOf(
    SettingItem(
        title = "Settings",
        description = "User Name | Security Code | Email | Address",
        icon = Icons.Rounded.Settings,
        onSettingItemClicked = { parentNavController ->
            parentNavController.navigate(NavigationRoutes.setting_screen.toString())
        }
    ),
    SettingItem(
        title = "Contact Us",
        description = "Contact a agent to get support",
        icon = Icons.Rounded.SupportAgent,
        onSettingItemClicked = { parentNavController ->
            parentNavController.navigate(NavigationRoutes.contact_us_screen.toString())
        }
    ),
    SettingItem(
        title = "Tutorials",
        description = "View tutorials for the app",
        icon = Icons.Rounded.Book,
        onSettingItemClicked = { parentNavController ->
            parentNavController.navigate(NavigationRoutes.setting_screen.toString())
        }
    ),
    SettingItem(
        title = "About App",
        description = "Permissions | Developers",
        icon = Icons.Rounded.Info,
        onSettingItemClicked = { parentNavController ->
            parentNavController.navigate(NavigationRoutes.setting_screen.toString())
        }
    )
)