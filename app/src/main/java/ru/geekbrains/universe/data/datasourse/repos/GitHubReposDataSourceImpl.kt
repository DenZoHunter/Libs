package ru.geekbrains.universe.data.datasourse.repos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.data.api.GitHubApi

class GitHubReposDataSourceImpl(
    private val gitHubApi: GitHubApi,
    private val url: String
) : GitHubReposDataSource {

    override fun fetchRepositories(): Single<List<GitHubRepos>> =
        gitHubApi.fetchRepositories(url)

}