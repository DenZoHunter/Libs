package ru.geekbrains.universe.presentation

import android.os.Bundle
import ru.geekbrains.universe.R
import ru.geekbrains.universe.presentation.abs.AbsActivity
import ru.geekbrains.universe.presentation.movies.MoviesListScreen
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(MoviesListScreen())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}