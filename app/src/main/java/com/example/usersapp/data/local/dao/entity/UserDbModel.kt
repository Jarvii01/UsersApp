package com.example.usersapp.data.local.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbModel(
    @PrimaryKey @ColumnInfo("id") val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("username") val username: String,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("address_street") val addressStreet: String,
    @ColumnInfo("address_suite") val addressSuite: String,
    @ColumnInfo("address_city") val addressCity: String,
    @ColumnInfo("phone") val phone: String,
    @ColumnInfo("website") val website: String,
    @ColumnInfo("company_name") val companyName: String,
    @ColumnInfo("company_catch_phrase") val companyCatchPhrase: String,
    @ColumnInfo("company_bs") val companyBs: String,

    )
