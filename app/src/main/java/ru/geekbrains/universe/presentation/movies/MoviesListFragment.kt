package ru.geekbrains.universe.presentation.movies

import androidx.fragment.app.Fragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.universe.R
import ru.geekbrains.universe.presentation.abs.AbsFragment
import javax.inject.Inject

class MoviesListFragment : AbsFragment(R.layout.fragment_movies_list) {
    @Inject
    lateinit var moviesListPresenterFactory: MoviesListPresenterFactory

    private val presenter: MoviesListPresenter by moxyPresenter {
        moviesListPresenterFactory.create()
    }

    companion object {

        fun newInstance(): Fragment =
            MoviesListFragment()
    }
}