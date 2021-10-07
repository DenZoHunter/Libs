package ru.geekbrains.universe.data.datasourse.repos

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.data.database.RoomDataBase

class RoomGithubRepositoriesCacheImpl(
    private val roomDataBase: RoomDataBase,
    private val userLogin: String
) : RoomGithubRepositoriesCache {
    override fun retain(repos: List<GitHubRepos>): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .retain(repos)
            .andThen(fetchRepositories())

    override fun fetchRepositories(): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .fetchRepos()
            .map { list -> list.filter { it.owner.login == userLogin } }
}