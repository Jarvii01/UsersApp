package com.example.usersapp

import android.app.Application
import com.example.usersapp.di.ApplicationComponent
import com.example.usersapp.di.DaggerApplicationComponent

class UsersApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}
