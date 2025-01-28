package com.example.usersapp.screens.userDetailsScreen

import androidx.lifecycle.ViewModel
import com.example.usersapp.domain.repository.UsersRepository
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    fun getUser(id: Int) = repository.getUser(id)
}
