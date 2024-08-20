package com.octochimp.phonefinder3.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Upsert
    suspend fun insertUser(user:User)

    @Query("SELECT * FROM user")
    fun getUser(): Flow<User?>

}