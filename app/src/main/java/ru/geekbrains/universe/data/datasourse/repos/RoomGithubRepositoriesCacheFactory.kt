package ru.geekbrains.universe.data.datasourse.repos

import android.content.Context
import ru.geekbrains.universe.data.database.RoomDataBaseFactory

object RoomGithubRepositoriesCacheFactory {

    fun create(context: Context, userLogin: String): RoomGithubRepositoriesCache =
        RoomGithubRepositoriesCacheImpl(
            RoomDataBaseFactory.createInMemory(context),
            userLogin
        )
}