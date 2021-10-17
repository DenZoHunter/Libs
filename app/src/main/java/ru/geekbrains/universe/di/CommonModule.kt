package ru.geekbrains.universe.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.geekbrains.universe.presentation.MainActivity

@Module
interface CommonModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}