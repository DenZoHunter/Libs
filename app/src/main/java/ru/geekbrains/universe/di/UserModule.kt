package ru.geekbrains.universe.di

import ru.geekbrains.universe.data.datasourse.user.GitHubUserDataSource
import ru.geekbrains.universe.data.datasourse.user.GitHubUserDataSourceImpl
import ru.geekbrains.universe.data.datasourse.user.RoomGithubUsersCache
import ru.geekbrains.universe.data.datasourse.user.RoomGithubUsersCacheImpl
import ru.geekbrains.universe.presentation.users.UsersFragment
import ru.geekbrains.universe.repository.user.GitHubUserRepository
import ru.geekbrains.universe.repository.user.GitHubUserRepositoryImpl
import ru.geekbrains.universe.presentation.user.UserFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface UserModule {

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @Binds
    fun bindGitHubUserRepository(gitHubUserRepositoryImpl: GitHubUserRepositoryImpl): GitHubUserRepository

    @Binds
    fun bindGitHubUserDataSource(gitHubUserDataSourceImpl: GitHubUserDataSourceImpl): GitHubUserDataSource

    @Binds
    fun bindRoomGithubUsersCache(roomGithubUsersCacheImpl: RoomGithubUsersCacheImpl): RoomGithubUsersCache

}