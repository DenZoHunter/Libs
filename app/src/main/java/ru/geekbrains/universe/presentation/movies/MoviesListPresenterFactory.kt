package ru.geekbrains.universe.presentation.movies

import dagger.assisted.AssistedFactory

@AssistedFactory
interface MoviesListPresenterFactory {

    fun create(): MoviesListPresenter

}