package ru.geekbrains.universe.data.datasourse.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface GitHubUserDataSource {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}