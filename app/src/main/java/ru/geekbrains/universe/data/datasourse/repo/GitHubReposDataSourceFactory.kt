package ru.geekbrains.universe.data.datasourse.repo

import ru.geekbrains.universe.data.api.GitHubApiFactory

object GitHubReposDataSourceFactory {

    fun create(): GitHubReposDataSource = GitHubReposDataSourceImpl(GitHubApiFactory.create())

}