package com.example.usersapp.data.dataSource

import com.example.usersapp.data.local.dao.entity.UserDbModel
import kotlinx.coroutines.flow.Flow

interface UsersLocalDataSource {

    fun getUserList(): Flow<List<UserDbModel>>

    fun getUser(id: Int): Flow<UserDbModel>

}
