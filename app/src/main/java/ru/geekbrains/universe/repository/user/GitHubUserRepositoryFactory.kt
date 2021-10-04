package ru.geekbrains.universe.repository.user

import ru.geekbrains.universe.data.datasourse.user.GitHubUserDataSourceFactory

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl(
        gitHubUserDataSource = GitHubUserDataSourceFactory.create(),
    )

}