package ru.geekbrains.universe.data.datasourse.user

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.data.api.GitHubApi

class GitHubUserDataSourceImpl(
    private val gitHubApi: GitHubApi,
) : GitHubUserDataSource {

    override fun fetchUsers(): Single<List<GitHubUser>> = gitHubApi.fetchUsers()

}