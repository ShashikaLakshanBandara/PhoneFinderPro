package com.octochimp.phonefinder3.data.navigation_items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        hasNews = false,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home

    ),
    BottomNavigationItem(
        title = "Find",
        batchCount = 15,
        hasNews = false,
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search
    ),
    BottomNavigationItem(
        title = "Profile",
        hasNews = false,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    )
)