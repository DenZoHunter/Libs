package ru.geekbrains.universe.presentation.users

import dagger.assisted.AssistedFactory

@AssistedFactory
interface UsersPresenterFactory {

    fun create(): UsersPresenter

}