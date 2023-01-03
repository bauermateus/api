package com.mbs.api_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbs.api_recycler.databinding.RecyclerContentBinding

class ApiAdapter: RecyclerView.Adapter<ApiAdapter.ViewHolder>() {
    private var userList: List<UserModel> = listOf()

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

    fun updateUsers(users : List<UserModel>) {
        userList = users
    }


    class ViewHolder(private val bind: RecyclerContentBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(user: UserModel) {
            bind.id.text = user.users[0].id.toString()
            bind.name.text = user.users[0].name
            bind.surname.text = user.users[0].surname
        }
    }
}