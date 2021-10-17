package ru.geekbrains.universe.domain.repository

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.domain.entity.Movie

interface MovieRepository {

    fun getMovies(): Observable<List<Movie>>

    fun getMovieById(id: Int): Observable<Movie>

}