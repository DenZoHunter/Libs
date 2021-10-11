package ru.geekbrains.universe.data.datasourse.repos

import io.reactivex.rxjava3.core.Single

interface RoomGithubRepositoriesCache : GitHubReposDataSource {

    fun retain(repos: List<GitHubRepos>, url: String, userLogin: String): Single<List<GitHubRepos>>

}