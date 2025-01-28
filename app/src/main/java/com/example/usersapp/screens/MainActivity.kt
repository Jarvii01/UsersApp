package com.example.usersapp.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.usersapp.R
import com.example.usersapp.UsersApp
import com.example.usersapp.data.remote.api.ApiFactory
import com.example.usersapp.di.ViewModelFactory
import com.example.usersapp.screens.usersScreen.UsersViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UsersViewModel::class.java]
    }

    private val component by lazy {
        (application as UsersApp).component
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadUsers()

    }
}
