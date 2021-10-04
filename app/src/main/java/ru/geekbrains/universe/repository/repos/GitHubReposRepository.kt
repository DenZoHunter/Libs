package ru.geekbrains.universe.repository.repos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos

interface GitHubReposRepository {

    fun getRepositories(url: String): Single<List<GitHubRepos>>

}