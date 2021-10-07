package ru.geekbrains.universe.data.datasourse.user

import android.content.Context
import ru.geekbrains.universe.data.database.RoomDataBaseFactory

object RoomGithubUsersCacheFactory {

    fun create(context: Context): RoomGithubUsersCache =
        RoomGithubUsersCacheImpl(
            RoomDataBaseFactory.createInMemory(context)
        )

}