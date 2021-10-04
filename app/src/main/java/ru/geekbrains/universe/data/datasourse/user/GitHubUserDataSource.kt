package ru.geekbrains.universe.data.datasourse.user

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubUser

interface GitHubUserDataSource {

    fun fetchUsers(): Single<List<GitHubUser>>

}
