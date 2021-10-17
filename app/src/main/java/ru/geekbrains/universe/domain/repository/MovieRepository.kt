package ru.geekbrains.universe.domain.repository

import ru.geekbrains.universe.domain.entity.Movie
import io.reactivex.rxjava3.core.Observable

interface MovieRepository {

    fun getMovies(): Observable<List<Movie>>

    fun getMovieById(id: Int): Observable<Movie>

}