package ru.geekbrains.universe.di

import ru.geekbrains.universe.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CommonModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}