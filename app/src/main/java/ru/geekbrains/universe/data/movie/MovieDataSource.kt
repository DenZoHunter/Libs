package ru.geekbrains.universe.data.movie

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.domain.entity.Movie

interface MovieDataSource {

    fun getMovies(): Observable<List<Movie>>

    fun getMovieById(id: Int): Observable<Movie>

}