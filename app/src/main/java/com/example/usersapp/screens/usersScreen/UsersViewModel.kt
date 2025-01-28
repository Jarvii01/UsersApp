package com.example.usersapp.screens.usersScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapp.domain.repository.UsersRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    fun loadUsers() = viewModelScope.launch {
        repository.loadData()
    }


}
