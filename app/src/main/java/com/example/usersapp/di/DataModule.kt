package com.example.usersapp.di

import android.content.Context
import com.example.usersapp.data.dataSource.UsersLocalDataSource
import com.example.usersapp.data.dataSource.UsersRemoteDataSource
import com.example.usersapp.data.local.AppDatabase
import com.example.usersapp.data.local.UsersLocalDataSourceImpl
import com.example.usersapp.data.local.dao.UsersDao
import com.example.usersapp.data.remote.ApiFactory
import com.example.usersapp.data.remote.ApiService
import com.example.usersapp.data.remote.UsersRemoteDataSourceImpl
import com.example.usersapp.data.repository.UsersRepositoryImpl
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
        fun provideUsersDao(context: Context): UsersDao =
            AppDatabase.getInstance(context).UsersDao()

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
