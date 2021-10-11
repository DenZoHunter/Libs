package ru.geekbrains.universe.data.datasourse.repos

import ru.geekbrains.universe.data.api.GitHubApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubReposDataSourceImpl @Inject constructor(
    private val gitHubApi: GitHubApi
) : GitHubReposDataSource {

    override fun fetchRepositories(url: String, userLogin: String): Single<List<GitHubRepos>> =
        gitHubApi.fetchRepositories(url)

}