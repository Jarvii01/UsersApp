package com.example.usersapp.data.repository

import android.util.Log
import com.example.usersapp.data.dataSource.UsersLocalDataSource
import com.example.usersapp.data.dataSource.UsersRemoteDataSource
import com.example.usersapp.data.local.dao.UsersDao
import com.example.usersapp.data.local.dao.entity.UserDbModel
import com.example.usersapp.data.mapper.toDbModelList
import com.example.usersapp.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersRemoteDataSource: UsersRemoteDataSource,
    private val usersLocalDataSource: UsersLocalDataSource,
    private val dao: UsersDao
) : UsersRepository {

    override suspend fun loadData() {
        val usersDto = usersRemoteDataSource.fetchUsersList()
        Log.d("UsersRepositoryImpl", usersDto.toString())
//        val usersDao = usersDto.toDbModelList()
//        dao.addUserList(usersDao)
    }

    override suspend fun getUsersList(): Flow<List<UserDbModel>> =
        usersLocalDataSource.getUserList()

    override suspend fun getUser(id: Int): Flow<UserDbModel> = usersLocalDataSource.getUser(id)
}
