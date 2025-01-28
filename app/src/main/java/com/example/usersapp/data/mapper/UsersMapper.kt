package com.example.usersapp.data.mapper

import com.example.usersapp.data.local.dao.entity.UserDbModel
import com.example.usersapp.data.remote.model.UserDto

fun UserDto.toDbModel(): UserDbModel = UserDbModel(
    id = id,
    name = name,
    username = username,
    email = email,
    addressStreet = address.street,
    addressSuite = address.suite,
    addressCity = address.city,
    phone = phone,
    website = website,
    companyName = company.name,
    companyCatchPhrase = company.catchPhrase,
    companyBs = company.bs
)

fun List<UserDto>.toDbModelList(): List<UserDbModel> = map { it.toDbModel() }
