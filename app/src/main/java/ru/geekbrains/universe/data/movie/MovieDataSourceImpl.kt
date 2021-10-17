package ru.geekbrains.universe.data.movie

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.data.api.MovieApi
import ru.geekbrains.universe.domain.entity.Movie
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi,
) : MovieDataSource {
    override fun getMovies(): Observable<List<Movie>> =
        movieApi
            .getMovies()
            .toObservable()

    override fun getMovieById(id: Int): Observable<Movie> =
        movieApi
            .getMovieById(id)
            .toObservable()
}