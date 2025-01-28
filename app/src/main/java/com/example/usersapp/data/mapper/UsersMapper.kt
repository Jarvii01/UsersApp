package com.example.usersapp.data.mapper

import com.example.usersapp.data.local.dao.entity.UserDbModel
import com.example.usersapp.data.remote.model.UserDto

fun UserDto.toDbModel(): UserDbModel = UserDbModel(
    id = id,
    name = name,
    username = username,
    email = email,
    addressStreet = address.firstOrNull()?.street.toString(),
    addressSuite = address.firstOrNull()?.suite.toString(),
    addressCity = address.firstOrNull()?.city.toString(),
    phone = phone,
    website = website,
    companyName = company.firstOrNull()?.name.toString(),
    companyCatchPhrase = company.firstOrNull()?.catchPhrase.toString(),
    companyBs = company.firstOrNull()?.bs.toString()
)

fun List<UserDto>.toDbModelList(): List<UserDbModel> = map { it.toDbModel() }
