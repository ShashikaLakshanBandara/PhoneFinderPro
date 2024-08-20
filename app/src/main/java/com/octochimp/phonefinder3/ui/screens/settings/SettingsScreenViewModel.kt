package com.octochimp.phonefinder3.ui.screens.settings


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octochimp.phonefinder3.data.database.User
import com.octochimp.phonefinder3.data.database.UserDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsScreenViewModel(private val dao: UserDao) : ViewModel() {
    private val _state = MutableStateFlow(SettingsState())
    private val _user = dao.getUser()


    val state = combine(_state, _user) { state, user ->
        if (user != null) {
            state.copy(
                user = user
            )
        } else {
            state.copy(
                user = User(
                    phone = "Null",
                    email = "Null",
                    code = "Null",
                    userName = "Null",
                ) // or handle as you prefer
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SettingsState())

    fun onEvent(events: SettingsEvents){
        when(events){
            SettingsEvents.SaveUser -> {
                val userName = state.value.userName
                val code = state.value.code
                val phone = state.value.phone
                val email = state.value.email

                val user = User(
                    userName = userName,
                    code = code,
                    email = email,
                    phone = phone
                )

                viewModelScope.launch {
                    dao.insertUser(user)
                }
                _state.update {
                    it.copy(
                        showConfirmCode = false
                    )
                }
            }
            SettingsEvents.hideConfirmCode -> {
                _state.update {
                    it.copy(
                        showConfirmCode = false
                    )
                }
            }
            is SettingsEvents.setCode -> {
                _state.update {
                    it.copy(
                        code = events.code
                    )
                }
            }
            is SettingsEvents.setEmail -> {
                _state.update {
                    it.copy(
                        email = events.email
                    )
                }
            }
            is SettingsEvents.setPhone -> {
                _state.update {
                    it.copy(
                        phone = events.phone
                    )
                }
            }
            is SettingsEvents.setUserName -> {
                _state.update {
                    it.copy(
                        userName = events.userName
                    )
                }
            }
            SettingsEvents.showConfirmCode -> {
                _state.update {
                    it.copy(
                        showConfirmCode = true
                    )
                }
            }

        }
    }

}
