package com.example.usersapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("city") val city: String,
)
