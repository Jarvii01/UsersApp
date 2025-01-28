package com.example.usersapp.data.local

import com.example.usersapp.data.dataSource.UsersLocalDataSource
import com.example.usersapp.data.local.dao.UsersDao
import com.example.usersapp.data.local.dao.entity.UserDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersLocalDataSourceImpl @Inject constructor(
    private val dao: UsersDao
) : UsersLocalDataSource {
    override suspend fun getUserList(): Flow<List<UserDbModel>> = dao.getUsers()

    override suspend fun getUser(id: Int): Flow<UserDbModel> = dao.getUserById(id)
}
