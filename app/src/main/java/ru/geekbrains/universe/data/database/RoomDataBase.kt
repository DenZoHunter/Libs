package ru.geekbrains.universe.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.universe.data.database.movie.MovieDao
import ru.geekbrains.universe.domain.entity.Movie


@Database(exportSchema = false, entities = [Movie::class], version = 1)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}