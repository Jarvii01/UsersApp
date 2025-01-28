package com.example.usersapp.data.dataSource

import com.example.usersapp.data.remote.model.UserDto

interface UsersRemoteDataSource {

    suspend fun fetchUsersList(): List<UserDto>
}
