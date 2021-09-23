package ru.geekbrains.universe.presentation.users

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.universe.data.GitHubUser

interface UsersView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showUsers(list: List<GitHubUser>)

}