package ru.geekbrains.universe.data.datasourse.repo

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos

interface GitHubReposDataSource {

    fun fetchRepositories(url: String): Single<List<GitHubRepos>>

}