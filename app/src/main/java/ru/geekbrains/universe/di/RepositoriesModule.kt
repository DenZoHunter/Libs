package ru.geekbrains.universe.di

import ru.geekbrains.universe.data.datasourse.repos.GitHubReposDataSource
import ru.geekbrains.universe.data.datasourse.repos.GitHubReposDataSourceImpl
import ru.geekbrains.universe.data.datasourse.repos.RoomGithubRepositoriesCache
import ru.geekbrains.universe.data.datasourse.repos.RoomGithubRepositoriesCacheImpl
import ru.geekbrains.universe.presentation.repositories.RepositoriesFragment
import ru.geekbrains.universe.presentation.repository.RepositoryDetailsFragment
import ru.geekbrains.universe.repository.repos.GitHubReposRepository
import ru.geekbrains.universe.repository.repos.GitHubReposRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface RepositoriesModule {

    @ContributesAndroidInjector
    fun bindRepositoriesFragment(): RepositoriesFragment

    @ContributesAndroidInjector
    fun bindRepositoryDetailsFragment(): RepositoryDetailsFragment

    @Binds
    fun bindGitHubReposRepository(gitHubReposRepositoryImpl: GitHubReposRepositoryImpl): GitHubReposRepository

    @Binds
    fun bindGitHubReposDataSource(gitHubReposDataSourceImpl: GitHubReposDataSourceImpl): GitHubReposDataSource

    @Binds
    fun bindRoomGithubRepositoriesCache(roomGithubRepositoriesCacheImpl: RoomGithubRepositoriesCacheImpl): RoomGithubRepositoriesCache

}