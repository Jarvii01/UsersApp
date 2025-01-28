package com.example.usersapp.screens.usersListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapp.domain.repository.UsersRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    fun loadUsers() = viewModelScope.launch {
        repository.loadData()
    }

    fun getUsers() = repository.getUsersList()



}
