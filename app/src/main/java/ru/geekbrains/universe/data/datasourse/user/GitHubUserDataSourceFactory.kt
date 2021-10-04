package ru.geekbrains.universe.data.datasourse.user

import ru.geekbrains.universe.data.api.GitHubApiFactory

object GitHubUserDataSourceFactory {

    fun create(): GitHubUserDataSource = GitHubUserDataSourceImpl(GitHubApiFactory.create())

}