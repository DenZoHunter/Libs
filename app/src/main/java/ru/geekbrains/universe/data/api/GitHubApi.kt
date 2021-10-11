package ru.geekbrains.universe.data.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(@Path("username") login: String): Single<GitHubUser>

    @GET
    fun fetchRepositories(@Url url: String): Single<List<GitHubRepos>>

}