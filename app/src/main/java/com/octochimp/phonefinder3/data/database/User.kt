package com.octochimp.phonefinder3.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    val userName :String = "",
    val code:String= "",
    val phone:String= "",
    val email:String= "",
    @PrimaryKey
    val id:Int = 0
)
