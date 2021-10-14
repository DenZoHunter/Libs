package ru.geekbrains.universe.presentation.repositories

import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.presentation.repository.RepositoryDetailsScreen
import ru.geekbrains.universe.repository.repos.GitHubReposRepository
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesPresenter @AssistedInject constructor(
    private val gitHubReposRepository: GitHubReposRepository,
    private val router: Router,
    @Assisted("url") private val url: String,
    @Assisted("userLogin") private val userLogin: String
) : MvpPresenter<RepositoriesView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            gitHubReposRepository
                .getRepositories(url = url, userLogin = userLogin)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    viewState::showRepositories,
                    viewState::showError,
                )
        )

    }

    fun displayRepositoryInfo(gitHubRepos: GitHubRepos) =
        router.navigateTo(RepositoryDetailsScreen(gitHubRepos.forks))

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}