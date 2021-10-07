package ru.geekbrains.universe.presentation.repositories.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.geekbrains.universe.data.database.RoomDataBase

class RepositoriesDiffUtil(
    private val oldList: List<RoomDataBase>,
    private val newList: List<RoomDataBase>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}