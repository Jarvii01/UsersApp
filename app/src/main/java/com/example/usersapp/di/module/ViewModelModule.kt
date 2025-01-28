package com.example.usersapp.di.module

import androidx.lifecycle.ViewModel
import com.example.usersapp.di.annotations.ViewModelKey
import com.example.usersapp.screens.userDetailsScreen.UserDetailsViewModel
import com.example.usersapp.screens.usersListScreen.UsersListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UsersListViewModel::class)
    fun bindUsersViewModel(viewModel: UsersListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailsViewModel::class)
    fun bindUserDetailsViewModel(viewModel: UserDetailsViewModel): ViewModel

}
