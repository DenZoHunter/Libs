package ru.geekbrains.universe.repository.repos

import ru.geekbrains.universe.data.datasourse.repo.GitHubReposDataSourceFactory

object GitHubReposRepositoryFactory {

    fun create(): GitHubReposRepository = GitHubReposRepositoryImpl(
        gitHubReposDataSource = GitHubReposDataSourceFactory.create(),
    )

}
