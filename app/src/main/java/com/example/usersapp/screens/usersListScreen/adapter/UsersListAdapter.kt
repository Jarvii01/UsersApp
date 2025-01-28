package com.example.usersapp.screens.usersListScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.usersapp.data.local.dao.entity.UserDbModel
import com.example.usersapp.databinding.UserCardBinding
import javax.inject.Inject

class UsersListAdapter @Inject constructor() :
    ListAdapter<UserDbModel, UserListViewHolder>(UserListDiffCallback) {

    var onUserItemClick: OnUserItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding = UserCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: UserListViewHolder, position: Int) {
        val users = getItem(position)
        with(viewHolder.binding) {
            tvName.text = users.name
            tvUsername.text = users.username
            root.setOnClickListener {
                onUserItemClick?.onUserItemClick(users)
            }
        }
    }

    interface OnUserItemClick {
        fun onUserItemClick(dbModel: UserDbModel)
    }


}
