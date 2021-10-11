package ru.geekbrains.universe.di

import android.content.Context
import androidx.room.Room
import ru.geekbrains.universe.data.database.RoomDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideRoomDataBase(context: Context): RoomDataBase =
        Room.inMemoryDatabaseBuilder(context, RoomDataBase::class.java)
            .fallbackToDestructiveMigration()
            .build()

}