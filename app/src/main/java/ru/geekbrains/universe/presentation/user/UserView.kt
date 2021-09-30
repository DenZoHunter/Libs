package ru.geekbrains.universe.presentation.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.universe.data.GitHubUser

interface UserView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLogin(user: GitHubUser)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)
}
