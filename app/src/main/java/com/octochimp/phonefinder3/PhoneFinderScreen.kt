package com.octochimp.phonefinder3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.octochimp.phonefinder3.data.navigation_items.NavigationRoutes
import com.octochimp.phonefinder3.ui.screens.ContactUsScreen
import com.octochimp.phonefinder3.ui.screens.MainHomeScreen
import com.octochimp.phonefinder3.ui.screens.settings.SettingsScreen
import com.octochimp.phonefinder3.ui.screens.SplashScreen
import com.octochimp.phonefinder3.ui.screens.settings.SettingsEvents
import com.octochimp.phonefinder3.ui.screens.settings.SettingsState
import kotlin.reflect.KFunction1


@Composable
fun PhoneFinder(
    parentNavController: NavHostController = rememberNavController(),
    state: SettingsState,
    onEvent: KFunction1<SettingsEvents, Unit>
) {

    NavHost(navController = parentNavController, startDestination = "splash_screen"){
        composable(route = NavigationRoutes.splash_screen.toString()){
            SplashScreen(parentNavController = parentNavController)
        }
        composable(route = NavigationRoutes.main_home_screen.toString()){
            MainHomeScreen(parentNavController = parentNavController)
        }
        composable(route = NavigationRoutes.setting_screen.toString()){
            SettingsScreen(parentNavController = parentNavController, state = state, onEvents = onEvent)
        }
        composable(route = NavigationRoutes.contact_us_screen.toString()){
            ContactUsScreen(parentNavController = parentNavController)
        }
    }

}


