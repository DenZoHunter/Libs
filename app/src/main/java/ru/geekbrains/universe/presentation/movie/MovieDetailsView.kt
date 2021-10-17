package ru.geekbrains.universe.presentation.movie

import ru.geekbrains.universe.presentation.model.MovieModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MovieDetailsView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showMovie(movie: MovieModel)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)

}