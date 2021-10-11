package ru.geekbrains.universe.repository.repos

import ru.geekbrains.universe.data.datasourse.repos.GitHubReposDataSource
import ru.geekbrains.universe.data.datasourse.repos.RoomGithubRepositoriesCache
import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.GitHubRepos
import javax.inject.Inject

class GitHubReposRepositoryImpl @Inject constructor(
    private val gitHubReposDataSource: GitHubReposDataSource,
    private val roomGithubRepositoriesCache: RoomGithubRepositoriesCache
) : GitHubReposRepository {

    override fun getRepositories(url: String, userLogin: String): Observable<List<GitHubRepos>> =
        Observable.merge(
            roomGithubRepositoriesCache.fetchRepositories(url = url, userLogin = userLogin).toObservable(),
            gitHubReposDataSource.fetchRepositories(url = url, userLogin = userLogin)
                .flatMap{roomGithubRepositoriesCache.retain(repos = it, url = url, userLogin = userLogin)}.toObservable()
        )

}