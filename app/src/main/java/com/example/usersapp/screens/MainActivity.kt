package com.example.usersapp.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.usersapp.R
import com.example.usersapp.UsersApp
import com.example.usersapp.databinding.ActivityMainBinding
import com.example.usersapp.screens.usersListScreen.UsersListFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as UsersApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        launchUsersListFragment()

    }

    private fun launchUsersListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, UsersListFragment())
            .commit()
    }

}
