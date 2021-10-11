package ru.geekbrains.universe.data.datasourse.repos

import ru.geekbrains.universe.data.database.RoomDataBase
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubRepos
import javax.inject.Inject

class RoomGithubRepositoriesCacheImpl @Inject constructor(
    private val roomDataBase: RoomDataBase
) : RoomGithubRepositoriesCache {
    override fun retain(repos: List<GitHubRepos>, url: String, userLogin: String): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .retain(repos)
            .andThen(fetchRepositories(url = url, userLogin = userLogin))

    override fun fetchRepositories(url: String, userLogin: String): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .fetchRepos()
            .map { list -> list.filter { it.owner.login == userLogin } }
}