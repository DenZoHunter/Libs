package ru.geekbrains.universe.data

class GitHubUserRepositoryImpl : GitHubUserRepository {
    private val repositories = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),

    )

    override fun getUsers(): List<GitHubUser> {
        return repositories
    }
}