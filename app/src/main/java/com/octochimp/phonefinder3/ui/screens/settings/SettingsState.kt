package com.octochimp.phonefinder3.ui.screens.settings

import com.octochimp.phonefinder3.data.database.User

data class SettingsState(
    val user: User = User(),
    val userName: String = "",
    val code: String = "",
    val email: String = "",
    val phone: String = "",
    val showConfirmCode: Boolean = false,
    )