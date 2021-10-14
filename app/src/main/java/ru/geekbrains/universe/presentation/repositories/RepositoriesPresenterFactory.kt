package ru.geekbrains.universe.presentation.repositories

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import ru.geekbrains.universe.presentation.repositories.RepositoriesPresenter

@AssistedFactory
interface RepositoriesPresenterFactory {

    fun create(@Assisted("url") url: String, @Assisted("userLogin") userLogin: String): RepositoriesPresenter

}