package com.example.usersapp.data.remote

import com.example.usersapp.data.dataSource.UsersRemoteDataSource
import com.example.usersapp.data.remote.model.UserDto
import javax.inject.Inject

class UsersRemoteDataSourceImpl @Inject constructor(
    private val api: ApiService
) : UsersRemoteDataSource {
    override suspend fun fetchUsersList(): List<UserDto> = api.getUsers()
}
