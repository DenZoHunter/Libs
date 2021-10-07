package ru.geekbrains.universe.presentation.repositories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.universe.R
import ru.geekbrains.universe.data.database.RoomDataBase

class RepositoriesAdapter(private val delegate: RepoClickListener) :
    RecyclerView.Adapter<RepositoriesViewHolder>() {
    private val list: MutableList<RoomDataBase> = mutableListOf()

    interface RepoClickListener {
        fun onClickRepo(repo: RoomDataBase)
    }

    fun submitList(users: List<RoomDataBase>) {
        val callback =
            RepositoriesDiffUtil(
                list,
                users
            )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(users)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.repo_list_item,
            parent,
            false
        )
        rootView.setOnClickListener {
            delegate.onClickRepo(it.tag as RoomDataBase)
        }
        return RepositoriesViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int = list.size

}