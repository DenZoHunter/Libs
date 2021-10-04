package ru.geekbrains.universe.presentation.users.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.universe.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var userLogin: TextView = itemView.findViewById(R.id.userText)

    fun bind(user: GitHubUser) {
        userLogin.text = user.login
    }

}