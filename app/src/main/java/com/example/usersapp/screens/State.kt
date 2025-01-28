package com.example.usersapp.screens

import com.example.usersapp.data.local.dao.entity.UserDbModel

sealed class State {

    data object Initial : State()
    data object Loading : State()
    data class Content(val usersList: List<UserDbModel>) : State()
}
