package ru.geekbrains.universe.data

import android.content.Context

object ConverterRepositoryFactory {

    fun create(context: Context): ConverterRepository =
        ConverterRepositoryImpl(context = context)

}