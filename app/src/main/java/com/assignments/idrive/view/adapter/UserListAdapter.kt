package com.assignments.idrive.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignments.idrive.databinding.UserListItemViewBinding
import com.assignments.idrive.model.pintrest.UserObject

import com.assignments.idrive.view.adapter.viewHolders.UserListViewHolder
 import com.assignments.idrive.viewmodel.UserListViewModel

class UserListAdapter(private val userListViewModel: UserListViewModel) : RecyclerView.Adapter<UserListViewHolder>() {
    var usersList: List<UserObject> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {


        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = UserListItemViewBinding.inflate(inflater, parent, false)
        return UserListViewHolder(dataBinding, userListViewModel)
    }

    override fun getItemCount() = usersList.size

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.setup(usersList[position])
    }

    fun updateRepoList(userList: List<UserObject>) {
        this.usersList = userList
        notifyDataSetChanged()
    }
}