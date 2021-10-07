package ru.geekbrains.universe.repository.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.GitHubUser

interface GitHubUserRepository {

    fun getUsers(): Observable<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}