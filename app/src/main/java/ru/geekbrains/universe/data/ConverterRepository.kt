package ru.geekbrains.universe.data

import android.net.Uri
import io.reactivex.rxjava3.core.Maybe

interface ConverterRepository {
    fun convert(uri: Uri?): Maybe<String>
}