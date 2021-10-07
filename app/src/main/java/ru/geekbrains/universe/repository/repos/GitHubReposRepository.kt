package ru.geekbrains.universe.repository.repos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.database.RoomDataBase

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.GitHubRepos

interface GitHubReposRepository {

    fun getRepositories(): Observable<List<GitHubRepos>>
}