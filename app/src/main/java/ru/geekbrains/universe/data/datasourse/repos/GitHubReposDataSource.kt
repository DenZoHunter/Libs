package ru.geekbrains.universe.data.datasourse.repos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos

interface GitHubReposDataSource {

    fun fetchRepositories(): Single<List<GitHubRepos>>
}