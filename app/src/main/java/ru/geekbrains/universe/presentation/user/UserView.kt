package ru.geekbrains.universe.presentation.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {

    @SingleState
    fun showUser(user: GitHubUser)

    @SingleState
    fun showError(error: Throwable)

}