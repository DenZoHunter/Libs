package ru.geekbrains.universe.data.datasourse.repo

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.data.api.GitHubApi

class GitHubReposDataSourceImpl(
    private val gitHubApi: GitHubApi
) : GitHubReposDataSource {

    override fun fetchRepositories(url: String): Single<List<GitHubRepos>> =
        gitHubApi.fetchRepositories(url)

}