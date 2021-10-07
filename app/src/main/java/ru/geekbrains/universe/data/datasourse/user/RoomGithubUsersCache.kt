package ru.geekbrains.universe.data.datasourse.user

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubUser

interface RoomGithubUsersCache : GitHubUserDataSource {

    fun retain(users: List<GitHubUser>): Single<List<GitHubUser>>

    fun retain(user: GitHubUser): Single<GitHubUser>

}