package ru.geekbrains.universe.repository.user

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.universe.data.GitHubUser

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

}