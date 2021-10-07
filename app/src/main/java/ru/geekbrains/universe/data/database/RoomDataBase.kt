package ru.geekbrains.universe.data.database


import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.data.database.repos.GitHubReposDao
import ru.geekbrains.universe.data.database.user.GitHubUserDao

@Database(exportSchema = false, entities = [GitHubUser::class, GitHubRepos::class], version = 1)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun gitHubUserDao(): GitHubUserDao

    abstract fun gitHubReposDao(): GitHubReposDao

}