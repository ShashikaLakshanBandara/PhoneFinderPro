package com.octochimp.phonefinder3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.octochimp.phonefinder3.data.database.UserDatabase
import com.octochimp.phonefinder3.ui.screens.settings.SettingsScreenViewModel
import com.octochimp.phonefinder3.ui.theme.PhoneFinder3Theme


class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user.db"
        ).build()
    }

    private val viewModel by viewModels<SettingsScreenViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SettingsScreenViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.navigationBarColor = 0xFF141414.toInt()
        setContent {
            PhoneFinder3Theme {
                val state by viewModel.state.collectAsState()
                PhoneFinder(state = state,onEvent = viewModel::onEvent)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhoneFinder3Theme {
        //PhoneFinder(state = state, onEvent = viewModel::onEvent)
    }
}