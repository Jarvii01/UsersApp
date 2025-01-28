package com.example.usersapp.screens.usersListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapp.domain.repository.UsersRepository
import com.example.usersapp.screens.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    val state: Flow<State> = repository.loadData
        .filter { it.isNotEmpty() }
        .map { State.Content(usersList = it) as State }
        .onStart { emit(State.Loading) }


}
