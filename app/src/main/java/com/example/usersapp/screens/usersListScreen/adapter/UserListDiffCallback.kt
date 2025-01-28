package com.example.usersapp.screens.usersListScreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.usersapp.data.local.dao.entity.UserDbModel

object UserListDiffCallback : DiffUtil.ItemCallback<UserDbModel>() {
    override fun areItemsTheSame(oldItem: UserDbModel, newItem: UserDbModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserDbModel, newItem: UserDbModel): Boolean {
        return oldItem == newItem
    }
}
