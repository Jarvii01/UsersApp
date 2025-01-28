package com.example.usersapp.domain.repository

import com.example.usersapp.data.local.dao.entity.UserDbModel
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    //Remote
    suspend fun loadData()

    //Local
    suspend fun getUsersList(): Flow<List<UserDbModel>>

    suspend fun getUser(id: Int): Flow<UserDbModel>

}
