package ru.geekbrains.universe.repository.repos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.data.datasourse.repo.GitHubReposDataSource

class GitHubReposRepositoryImpl(
    private val gitHubReposDataSource: GitHubReposDataSource
) : GitHubReposRepository {

    override fun getRepositories(url: String): Single<List<GitHubRepos>> =
        gitHubReposDataSource
            .fetchRepositories(url)

}