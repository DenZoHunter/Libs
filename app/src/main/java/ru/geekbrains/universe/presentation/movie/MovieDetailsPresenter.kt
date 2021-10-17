package ru.geekbrains.universe.presentation.movie

import ru.geekbrains.universe.domain.repository.MovieRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class MovieDetailsPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    @Assisted private val id: Int
) : MvpPresenter<MovieDetailsView>() {

}