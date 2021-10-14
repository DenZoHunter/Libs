package ru.geekbrains.universe.presentation.user

import dagger.assisted.AssistedFactory

@AssistedFactory
interface UserPresenterFactory {

    fun create(userLogin: String): UserPresenter

}