package ru.geekbrains.universe.data.datasourse.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.data.api.GitHubApi

class GitHubUserDataSourceImpl(
    private val gitHubApi: GitHubApi,
) : GitHubUserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> = gitHubApi.fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

}