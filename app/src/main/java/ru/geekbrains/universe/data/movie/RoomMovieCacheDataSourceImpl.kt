package ru.geekbrains.universe.data.movie

import ru.geekbrains.universe.data.database.RoomDataBase
import ru.geekbrains.universe.domain.entity.Movie
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RoomMovieCacheDataSourceImpl @Inject constructor(
    private val roomDataBase: RoomDataBase
) : RoomMovieCacheDataSource {
    override fun retain(movies: List<Movie>): Observable<List<Movie>> =
        roomDataBase
            .movieDao()
            .retain(movies)
            .andThen(getMovies())

    override fun retain(movie: Movie): Observable<Movie> =
        roomDataBase
            .movieDao()
            .retain(movie)
            .andThen(getMovieById(movie.id))

    override fun getMovies(): Observable<List<Movie>> =
        roomDataBase
            .movieDao()
            .fetchMovies()

    override fun getMovieById(id: Int): Observable<Movie> =
        roomDataBase
            .movieDao()
            .fetchMovieById(id)
}