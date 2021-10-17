package ru.geekbrains.universe.presentation.movies

import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import moxy.MvpPresenter
import ru.geekbrains.universe.domain.repository.MovieRepository

class MoviesListPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    private val router: Router,
) : MvpPresenter<MoviesListView>() {

}