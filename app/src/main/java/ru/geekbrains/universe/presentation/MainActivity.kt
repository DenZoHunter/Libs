package ru.geekbrains.universe.presentation

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.geekbrains.universe.presentation.abs.AbsActivity
import ru.geekbrains.universe.presentation.users.UsersScreen


class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(UsersScreen())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}
