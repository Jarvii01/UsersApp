package com.example.usersapp.di.module

import android.app.Application
import android.content.Context
import com.example.usersapp.data.dataSource.UsersLocalDataSource
import com.example.usersapp.data.dataSource.UsersRemoteDataSource
import com.example.usersapp.data.local.AppDatabase
import com.example.usersapp.data.local.UsersLocalDataSourceImpl
import com.example.usersapp.data.local.dao.UsersDao
import com.example.usersapp.data.remote.api.ApiFactory
import com.example.usersapp.data.remote.api.ApiService
import com.example.usersapp.data.remote.UsersRemoteDataSourceImpl
import com.example.usersapp.data.repository.UsersRepositoryImpl
import com.example.usersapp.di.annotations.ApplicationScope
import com.example.usersapp.domain.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @[Binds ApplicationScope]
    fun bindUsersRepository(impl: UsersRepositoryImpl): UsersRepository

    companion object {
        @[Provides ApplicationScope]
        fun provideApiService(): ApiService = ApiFactory.api

        @[Provides ApplicationScope]
        fun provideUsersDao(application: Application): UsersDao =
            AppDatabase.getInstance(application).UsersDao()

        @[Provides ApplicationScope]
        fun provideUsersRemoteDataSource(apiService: ApiService): UsersRemoteDataSource {
            return UsersRemoteDataSourceImpl(apiService)
        }

        @[Provides ApplicationScope]
        fun provideUsersLocalDataSource(dao: UsersDao): UsersLocalDataSource {
            return UsersLocalDataSourceImpl(dao)
        }

    }


}
