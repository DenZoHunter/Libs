package ru.geekbrains.universe.presentation.movies

import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.geekbrains.universe.domain.repository.MovieRepository
import ru.geekbrains.universe.presentation.model.MovieModel
import ru.geekbrains.universe.presentation.movie.MovieDetailsScreen

class MoviesListPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    private val router: Router,
    private val schedulers: ru.geekbrains.universe.scheduler.Schedulers,
) : MvpPresenter<MoviesListView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            movieRepository
                .getMovies()
                .map { movies -> movies.map(MovieModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showMovies,
                    viewState::showError,
                )
        )

    }

    fun displayMovie(movie: MovieModel) = router.navigateTo(MovieDetailsScreen(movie.id))

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}