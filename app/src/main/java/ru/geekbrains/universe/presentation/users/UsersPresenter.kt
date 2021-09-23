package ru.geekbrains.universe.presentation.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.data.GitHubUserRepository
import ru.geekbrains.universe.presentation.user.UserScreen

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        userRepository
            .getUsers()
            .let(viewState::showUsers)

    }

    fun displayUser(user: GitHubUser) = router.navigateTo(UserScreen(user.login))

}