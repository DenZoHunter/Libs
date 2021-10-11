package ru.geekbrains.universe.repository.repos

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.GitHubRepos

interface GitHubReposRepository {

    fun getRepositories(url: String, userLogin: String): Observable<List<GitHubRepos>>

}