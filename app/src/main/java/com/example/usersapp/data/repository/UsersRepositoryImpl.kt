package com.example.usersapp.data.repository

import android.app.Application
import com.example.usersapp.data.dataSource.UsersLocalDataSource
import com.example.usersapp.data.dataSource.UsersRemoteDataSource
import com.example.usersapp.data.local.AppDatabase
import com.example.usersapp.data.local.dao.UsersDao
import com.example.usersapp.data.local.dao.entity.UserDbModel
import com.example.usersapp.data.mapper.toDbModelList
import com.example.usersapp.domain.repository.UsersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersRemoteDataSource: UsersRemoteDataSource,
    private val usersLocalDataSource: UsersLocalDataSource,
    private val dao: UsersDao,
) : UsersRepository {

    override val loadData: Flow<List<UserDbModel>> = flow {
        val usersDto = usersRemoteDataSource.fetchUsersList()
        val usersDao = usersDto.toDbModelList()
        emit(usersDao.sortedBy { it.username })
        dao.addUserList(usersDao)
    }.stateIn(
        scope = CoroutineScope(Dispatchers.Default),
        started = SharingStarted.Lazily,
        initialValue = listOf()
    )

    override fun getUser(id: Int): Flow<UserDbModel> = usersLocalDataSource.getUser(id)
}
