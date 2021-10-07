package ru.geekbrains.universe.repository.user

import android.content.Context
import ru.geekbrains.universe.data.datasourse.user.GitHubUserDataSourceFactory
import ru.geekbrains.universe.data.datasourse.user.RoomGithubUsersCacheFactory

object GitHubUserRepositoryFactory {

    private var repository: GitHubUserRepository? = null

    private fun getInstance(context: Context): GitHubUserRepository {
        if (repository == null) {
            repository = GitHubUserRepositoryImpl(
                gitHubUserDataSource = GitHubUserDataSourceFactory.create(),
                roomGithubUsersCache = RoomGithubUsersCacheFactory.create(context)
            )
        }

        return repository!!
    }

    fun create(context: Context): GitHubUserRepository = getInstance(context)

}