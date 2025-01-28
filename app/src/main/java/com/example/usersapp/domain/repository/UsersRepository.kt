package com.example.usersapp.domain.repository

import com.example.usersapp.data.local.dao.entity.UserDbModel
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    //Remote
    suspend fun loadData()

    //Local
    fun getUsersList(): Flow<List<UserDbModel>>

    fun getUser(id: Int): Flow<UserDbModel>

}
