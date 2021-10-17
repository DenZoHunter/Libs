package ru.geekbrains.universe.presentation.movies

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.universe.presentation.model.MovieModel

interface MoviesListView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showMovies(list: List<MovieModel>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)
}