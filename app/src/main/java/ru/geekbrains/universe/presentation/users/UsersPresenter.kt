package ru.geekbrains.universe.presentation.users

import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.presentation.user.UserScreen
import ru.geekbrains.universe.repository.user.GitHubUserRepository

class UsersPresenter @AssistedInject constructor(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<UsersView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            userRepository
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError,
                )
        )

    }

    fun displayUser(user: GitHubUser) = router.navigateTo(UserScreen(user.login))

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}