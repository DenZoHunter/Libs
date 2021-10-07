package ru.geekbrains.universe.repository.repos

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.data.datasourse.repos.GitHubReposDataSource
import ru.geekbrains.universe.data.datasourse.repos.RoomGithubRepositoriesCache

class GitHubReposRepositoryImpl(
    private val gitHubReposDataSource: GitHubReposDataSource,
    private val roomGithubRepositoriesCache: RoomGithubRepositoriesCache
) : GitHubReposRepository {

    override fun getRepositories(): Observable<List<GitHubRepos>> =
        Observable.merge(
            roomGithubRepositoriesCache.fetchRepositories().toObservable(),
            gitHubReposDataSource.fetchRepositories()
                .flatMap(roomGithubRepositoriesCache::retain).toObservable()
        )

}