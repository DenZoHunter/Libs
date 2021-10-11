package ru.geekbrains.universe.repository.user

import ru.geekbrains.universe.data.datasourse.user.GitHubUserDataSource
import ru.geekbrains.universe.data.datasourse.user.RoomGithubUsersCache
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.GitHubUser
import javax.inject.Inject

class GitHubUserRepositoryImpl @Inject constructor(
    private val gitHubUserDataSource: GitHubUserDataSource,
    private val roomGithubUsersCache: RoomGithubUsersCache
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            roomGithubUsersCache.getUsers().toObservable(),
            gitHubUserDataSource.getUsers().flatMap(roomGithubUsersCache::retain).toObservable()
        )

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        roomGithubUsersCache.getUserByLogin(userId)
            .onErrorResumeNext {
                gitHubUserDataSource.getUserByLogin(userId)
            }

}