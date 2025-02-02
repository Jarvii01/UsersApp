package com.example.usersapp.di

import android.app.Application
import com.example.usersapp.UsersApp
import com.example.usersapp.di.annotations.ApplicationScope
import com.example.usersapp.di.module.DataModule
import com.example.usersapp.di.module.ViewModelModule
import com.example.usersapp.screens.MainActivity
import com.example.usersapp.screens.userDetailsScreen.UserDetailsFragment
import com.example.usersapp.screens.usersListScreen.UsersListFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {


    fun inject(context: UsersApp)

    fun inject(activity: MainActivity)

    fun inject(fragment: UsersListFragment)

    fun inject(fragment: UserDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}
