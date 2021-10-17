package ru.geekbrains.universe.presentation.movies

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.ktx.moxyPresenter
import ru.geekbrains.universe.R
import ru.geekbrains.universe.presentation.abs.AbsFragment
import ru.geekbrains.universe.presentation.model.MovieModel
import ru.geekbrains.universe.presentation.movies.adapter.MoviesListAdapter
import javax.inject.Inject

class MoviesListFragment : AbsFragment(R.layout.fragment_movies_list),MoviesListView,
    MoviesListAdapter.MovieClickListener {
    @Inject
    lateinit var moviesListPresenterFactory: MoviesListPresenterFactory

    private val presenter: MoviesListPresenter by moxyPresenter {
        moviesListPresenterFactory.create()
    }

    private var moviesList: RecyclerView? = null

    private val moviesListAdapter: MoviesListAdapter = MoviesListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesList = requireActivity().findViewById(R.id.moviesList)
        moviesList?.layoutManager = LinearLayoutManager(requireContext())
        moviesList?.adapter = moviesListAdapter
    }

    override fun showMovies(list: List<MovieModel>) {
        moviesListAdapter.submitList(moviesList = list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun onClickMovie(movie: MovieModel) {
        presenter.displayMovie(movie = movie)
    }

    companion object {

        fun newInstance(): Fragment =
            MoviesListFragment()
    }

}