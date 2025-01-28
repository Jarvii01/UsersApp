package com.example.usersapp.domain.repository

import com.example.usersapp.data.local.dao.entity.UserDbModel
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    //Remote
    val loadData: Flow<List<UserDbModel>>

    //Local
    fun getUser(id: Int): Flow<UserDbModel>

}
