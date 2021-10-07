package ru.geekbrains.universe.data.datasourse.repos

import ru.geekbrains.universe.data.api.GitHubApiFactory

object GitHubReposDataSourceFactory {

    fun create(url: String): GitHubReposDataSource = GitHubReposDataSourceImpl(GitHubApiFactory.create(), url)

}