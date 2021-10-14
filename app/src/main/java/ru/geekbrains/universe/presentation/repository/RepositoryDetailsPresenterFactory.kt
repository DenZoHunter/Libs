package ru.geekbrains.universe.presentation.repository

import dagger.assisted.AssistedFactory

@AssistedFactory
interface RepositoryDetailsPresenterFactory {

    fun create(countForks: Int?): RepositoryDetailsPresenter

}