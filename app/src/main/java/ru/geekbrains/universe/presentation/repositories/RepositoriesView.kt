package ru.geekbrains.universe.presentation.repositories

import ru.geekbrains.universe.data.database.RoomDataBase
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface RepositoriesView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRepositories(list: List<RoomDataBase>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)

}