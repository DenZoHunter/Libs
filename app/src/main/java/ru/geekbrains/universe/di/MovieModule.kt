package ru.geekbrains.universe.di

import ru.geekbrains.universe.data.movie.MovieDataSource
import ru.geekbrains.universe.data.movie.MovieDataSourceImpl
import ru.geekbrains.universe.data.movie.RoomMovieCacheDataSource
import ru.geekbrains.universe.data.movie.RoomMovieCacheDataSourceImpl
import ru.geekbrains.universe.domain.repository.MovieRepository
import ru.geekbrains.universe.domain.repository.MovieRepositoryImpl
import ru.geekbrains.universe.presentation.movie.MovieDetailsFragment
import ru.geekbrains.universe.presentation.movies.MoviesListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MovieModule {

    @ContributesAndroidInjector
    fun bindMovieDetailsFragment(): MovieDetailsFragment

    @ContributesAndroidInjector
    fun bindMoviesListFragment(): MoviesListFragment

    @Binds
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    fun bindMovieDataSource(movieDataSourceImpl: MovieDataSourceImpl): MovieDataSource

    @Binds
    fun bindRoomMovieCacheDataSource(roomMovieCacheDataSourceImpl: RoomMovieCacheDataSourceImpl): RoomMovieCacheDataSource

}