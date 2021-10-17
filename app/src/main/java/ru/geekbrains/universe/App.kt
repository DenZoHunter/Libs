package ru.geekbrains.universe

import ru.geekbrains.universe.di.DaggerAppComponent
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.geekbrains.universe.scheduler.DefaultSchedulers

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .withSchedulers(DefaultSchedulers())
            .apply {
                val cicerone: Cicerone<Router> = Cicerone.create()

                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()

}