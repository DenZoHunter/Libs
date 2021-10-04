package ru.geekbrains.universe.data.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.data.GitHubUser

interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET
    fun fetchRepositories(@Url url: String): Single<List<GitHubRepos>>

}