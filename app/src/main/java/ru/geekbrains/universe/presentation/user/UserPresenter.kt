package ru.geekbrains.universe.presentation.user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.universe.presentation.repositories.RepositoriesScreen
import ru.geekbrains.universe.repository.user.GitHubUserRepository

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables.add(
            userRepository
                .getUserByLogin(userLogin)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
        )
    }

    fun displayRepositories() =
        disposables.add(
            userRepository
                .getUserByLogin(userLogin)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { router.navigateTo(RepositoriesScreen(it.repos_url, it.login)) },
                    viewState::showError
                )
        )

    override fun onDestroy() {
        disposables.clear()
    }

}