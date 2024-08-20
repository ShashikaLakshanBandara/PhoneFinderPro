package com.octochimp.phonefinder3.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.octochimp.phonefinder3.PhoneFinderViewModel
import com.octochimp.phonefinder3.data.navigation_items.items
import com.octochimp.phonefinder3.ui.theme.BottomNaviColor

val viewModel:PhoneFinderViewModel = PhoneFinderViewModel()

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainHomeScreen(
    mainHomeNavController: NavHostController = rememberNavController(),
    parentNavController: NavHostController
) {
    val selectedItemIndex = viewModel.selectedItemNavigationIndex

    Scaffold(bottomBar = {
        NavigationBar(
            containerColor = BottomNaviColor

        ) {
            items.forEachIndexed { index, bottomNavigationItem ->
                NavigationBarItem(modifier = Modifier.height(50.dp),
                    selected = selectedItemIndex == index,
                    onClick = {
                        Log.d("shashika", "Navi button clicked")
                        viewModel.setSelectedItemIndex(index)
                    },
                    icon = {
                        BadgedBox(badge = {
                            if (bottomNavigationItem.batchCount != null) {
                                Badge {
                                    Text(text = bottomNavigationItem.batchCount.toString())
                                }
                            } else if (bottomNavigationItem.hasNews) {
                                Badge()
                            }
                        }) {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    bottomNavigationItem.selectedIcon
                                } else {
                                    bottomNavigationItem.unselectedIcon
                                }, contentDescription = bottomNavigationItem.title
                            )
                        }
                    },
                    label = {
                        Text(text = bottomNavigationItem.title)
                    })

            }
        }


    }) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {
            Log.d("shashika", "selectedItemIndex = $selectedItemIndex")
            when (selectedItemIndex) {
                0 -> HomeScreen()
                1 -> FindScreen()
                else -> ProfileScreen(parentNavController = parentNavController)
            }

//            NavHost(navController = mainHomeNavController, startDestination = NavigationRoutes.home_screen.toString()) {
//                composable(route=NavigationRoutes.home_screen.toString()){
//                    HomeScreen()
//                }
//                composable(route = NavigationRoutes.find_screen.toString()){
//                    FindScreen()
//                }
//                composable(route = NavigationRoutes.profile_screen.toString()){
//                    Log.d("shashika","NavigationRoutes.profile_screen.toString()")
//                    ProfileScreen(parentNavController = parentNavController)
//                }
//            }
        }


    }

}