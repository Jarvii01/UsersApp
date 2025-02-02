package com.example.usersapp.data.remote.api

import com.example.usersapp.data.remote.model.UserDto
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<UserDto>
}
