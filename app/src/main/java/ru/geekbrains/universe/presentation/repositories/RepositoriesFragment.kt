package ru.geekbrains.universe.presentation.repositories

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.universe.App
import ru.geekbrains.universe.R
import ru.geekbrains.universe.data.GitHubRepos
import ru.geekbrains.universe.presentation.repositories.adapter.RepositoriesAdapter
import ru.geekbrains.universe.repository.repos.GitHubReposRepositoryFactory

class RepositoriesFragment : MvpAppCompatFragment(R.layout.fragment_repositories), RepositoriesView, RepositoriesAdapter.RepoClickListener {
    private var repoList: RecyclerView? = null
    private val repositoriesAdapter: RepositoriesAdapter = RepositoriesAdapter(this)
    private var argUrl: String? = null

    private val presenter: RepositoriesPresenter by moxyPresenter {
        RepositoriesPresenter(
            gitHubReposRepository = GitHubReposRepositoryFactory.create(),
            url = argUrl,
            router = App.router
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            argUrl = it.getString(ARG_URL)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repoList = requireActivity().findViewById(R.id.repoList)
        repoList?.layoutManager = LinearLayoutManager(context)
        repoList?.adapter = repositoriesAdapter
    }

    companion object {
        private const val ARG_URL = "repo info"

        @JvmStatic
        fun newInstance(url: String): Fragment =
            RepositoriesFragment().apply {
                arguments = bundleOf(
                    ARG_URL to url
                )
            }

    }

    override fun showRepositories(list: List<GitHubRepos>) {
        repositoriesAdapter.submitList(list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun onClickRepo(repo: GitHubRepos) {
        presenter.displayRepositoryInfo(repo)
    }

}