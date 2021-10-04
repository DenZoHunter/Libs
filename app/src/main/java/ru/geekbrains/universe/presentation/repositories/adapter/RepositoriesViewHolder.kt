package ru.geekbrains.universe.presentation.repositories.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.universe.R
import ru.geekbrains.universe.data.GitHubRepos

class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var repoText: TextView = itemView.findViewById(R.id.repoText)

    fun bind(user: GitHubRepos) {
        repoText.text = user.name
    }

}