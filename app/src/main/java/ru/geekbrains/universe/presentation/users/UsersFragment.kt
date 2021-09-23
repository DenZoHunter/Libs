package ru.geekbrains.universe.presentation.users

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.universe.App.Navigator.router
import ru.geekbrains.universe.R
import ru.geekbrains.universe.data.GitHubUser
import ru.geekbrains.universe.data.GitHubUserRepository
import ru.geekbrains.universe.presentation.users.adapter.UsersAdapter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView,
    UsersAdapter.UserClickListener {
    private lateinit var userList: RecyclerView
    private lateinit var userAdapter: UsersAdapter

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepository(),
            router = router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userAdapter = UsersAdapter(this)
        userList = requireActivity().findViewById(R.id.userList)
        userList.layoutManager = LinearLayoutManager(context)
        userList.adapter = userAdapter
    }

    override fun showUsers(list: List<GitHubUser>) {
        userAdapter.submitList(users = list)
    }

    override fun onClickUser(user: GitHubUser) {
        presenter.displayUser(user = user)
    }

}