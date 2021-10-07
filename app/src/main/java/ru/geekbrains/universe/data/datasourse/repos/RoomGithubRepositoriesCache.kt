package ru.geekbrains.universe.data.datasourse.repos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos

interface RoomGithubRepositoriesCache : GitHubReposDataSource {

    fun retain(repos: List<GitHubRepos>): Single<List<GitHubRepos>>

}