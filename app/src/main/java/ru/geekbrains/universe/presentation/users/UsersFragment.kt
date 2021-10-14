package ru.geekbrains.universe.presentation.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.ktx.moxyPresenter
import ru.geekbrains.universe.R
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.presentation.abs.AbsFragment
import ru.geekbrains.universe.presentation.users.adapter.UsersAdapter
import javax.inject.Inject


class UsersFragment : AbsFragment(R.layout.fragment_users), UsersView,
    UsersAdapter.UserClickListener {
    @Inject
    lateinit var usersPresenterFactory: UsersPresenterFactory

    private var userList: RecyclerView? = null
    private val userAdapter: UsersAdapter = UsersAdapter(this)

    private val presenter: UsersPresenter by moxyPresenter {
        usersPresenterFactory.create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userList = requireActivity().findViewById(R.id.userList)
        userList?.layoutManager = LinearLayoutManager(context)
        userList?.adapter = userAdapter
    }

    override fun showUsers(list: List<GitHubUser>) {
        userAdapter.submitList(users = list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun onClickUser(user: GitHubUser) {
        presenter.displayUser(user = user)
    }

}