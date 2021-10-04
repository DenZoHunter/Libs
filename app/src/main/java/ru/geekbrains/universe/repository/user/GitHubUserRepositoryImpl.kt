package ru.geekbrains.universe.repository.user

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.data.datasourse.user.GitHubUserDataSource

class GitHubUserRepositoryImpl(
    private val gitHubUserDataSource: GitHubUserDataSource
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubUserDataSource.fetchUsers()

}