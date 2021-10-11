package ru.geekbrains.universe.data.datasourse.repos

import io.reactivex.rxjava3.core.Single

interface GitHubReposDataSource {

    fun fetchRepositories(url: String, userLogin: String): Single<List<GitHubRepos>>

}