package ru.geekbrains.universe.domain.repository

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.movie.MovieDataSource
import ru.geekbrains.universe.data.movie.RoomMovieCacheDataSource
import ru.geekbrains.universe.domain.entity.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val roomMovieCacheDataSource: RoomMovieCacheDataSource
) : MovieRepository {

    override fun getMovies(): Observable<List<Movie>> =
        Observable.merge(
            roomMovieCacheDataSource
                .getMovies(),
            movieDataSource
                .getMovies()
                .flatMap(roomMovieCacheDataSource::retain)
        )

    override fun getMovieById(id: Int): Observable<Movie> =
        roomMovieCacheDataSource
            .getMovieById(id)
            .onErrorResumeNext {
                movieDataSource.getMovieById(id)
            }

}