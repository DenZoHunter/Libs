package ru.geekbrains.universe.data.database.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.universe.domain.entity.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun fetchMovies(): Observable<List<Movie>>

    @Query("SELECT * FROM movie WHERE id LIKE :id LIMIT 1")
    fun fetchMovieById(id: Int): Observable<Movie>

    @Insert(onConflict = REPLACE)
    fun retain(movies: List<Movie>): Completable

    @Update(onConflict = REPLACE)
    fun retain(movie: Movie): Completable

}