package ru.geekbrains.universe.presentation.user

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.universe.data.GitHubUser

interface UserView : MvpView {


    @StateStrategyType(SingleStateStrategy::class)
    fun showLogin(user: GitHubUser)

    @StateStrategyType(SingleStateStrategy::class)
    fun showError(throwable: Throwable)

    @StateStrategyType(SingleStateStrategy::class)
    fun undefinedLogin()

}