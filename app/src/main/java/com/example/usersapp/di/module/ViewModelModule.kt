package com.example.usersapp.di.module

import androidx.lifecycle.ViewModel
import com.example.usersapp.di.annotations.ViewModelKey
import com.example.usersapp.screens.usersScreen.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    fun bindUsersViewModel(viewModel: UsersViewModel): ViewModel

}
