package ru.geekbrains.universe.data

interface GitHubUserRepository {

    fun getUsers(): List<GitHubUser>
}