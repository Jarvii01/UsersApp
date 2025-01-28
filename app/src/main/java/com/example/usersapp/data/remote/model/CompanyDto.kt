package com.example.usersapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CompanyDto(
    @SerializedName("name") val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    @SerializedName("bs") val bs: String,
)
