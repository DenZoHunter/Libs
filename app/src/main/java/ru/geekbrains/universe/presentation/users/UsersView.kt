package ru.geekbrains.universe.presentation.users

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UsersView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showUsers(list: List<GitHubUser>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)

}