package ru.geekbrains.universe.data.movie

import ru.geekbrains.universe.domain.entity.Movie
import io.reactivex.rxjava3.core.Observable


interface RoomMovieCacheDataSource : MovieDataSource {

    fun retain(movies: List<Movie>): Observable<List<Movie>>

    fun retain(movie: Movie): Observable<Movie>

}