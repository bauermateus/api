package com.mbs.api_recycler

import UserModel
import Users
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbs.api_recycler.databinding.RecyclerContentBinding

class ApiAdapter : RecyclerView.Adapter<ApiAdapter.ViewHolder>() {
    private var userList: List<Users> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = RecyclerContentBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUsers(users: UserModel) {
        userList = users.users
        notifyDataSetChanged()
    }


    class ViewHolder(private val bind: RecyclerContentBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun bind(user: Users) {
            bind.id.text = user.id.toString()
            bind.name.text = user.name
            bind.surname.text = user.surname
            bind.email.text = user.email
        }
    }
}