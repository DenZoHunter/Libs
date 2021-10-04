package ru.geekbrains.universe.presentation.users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.presentation.repositories.RepositoriesScreen
import ru.geekbrains.universe.repository.user.GitHubUserRepository


class UsersPresenter(
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

    fun displayRepositories(user: GitHubUser) = router.navigateTo(RepositoriesScreen(user.repos_url))

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}