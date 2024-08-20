package com.octochimp.phonefinder3.ui.screens.settings

sealed interface SettingsEvents {
    data object SaveUser:SettingsEvents
    data class setUserName(val userName:String):SettingsEvents
    data class setEmail(val email:String):SettingsEvents
    data class setPhone(val phone:String):SettingsEvents
    data class setCode(val code:String):SettingsEvents
    data object showConfirmCode:SettingsEvents
    data object hideConfirmCode : SettingsEvents
}