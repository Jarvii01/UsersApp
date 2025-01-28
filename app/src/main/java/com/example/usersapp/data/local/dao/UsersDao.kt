package com.example.usersapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.usersapp.data.local.dao.entity.UserDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<UserDbModel>>

    @Query("SELECT * FROM users WHERE id == :id LIMIT 1 ")
    fun getUserById(id: Int): Flow<UserDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserList(list: List<UserDbModel>)

}
