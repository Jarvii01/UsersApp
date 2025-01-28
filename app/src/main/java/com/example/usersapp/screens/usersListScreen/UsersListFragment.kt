package com.example.usersapp.screens.usersListScreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.usersapp.R
import com.example.usersapp.UsersApp
import com.example.usersapp.data.local.dao.entity.UserDbModel
import com.example.usersapp.databinding.FragmentUsersListBinding
import com.example.usersapp.di.ViewModelFactory
import com.example.usersapp.screens.State
import com.example.usersapp.screens.userDetailsScreen.UserDetailsFragment
import com.example.usersapp.screens.usersListScreen.adapter.UsersListAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListFragment : Fragment(R.layout.fragment_users_list) {

    private val component by lazy {
        (requireActivity().application as UsersApp).component
    }

    private var _binding: FragmentUsersListBinding? = null
    private val binding: FragmentUsersListBinding
        get() = _binding ?: throw RuntimeException("UsersListFragment is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UsersListViewModel::class.java]
    }

    private val usersListAdapter = UsersListAdapter()

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsersList.adapter = usersListAdapter
        observeViewModel()
        usersListAdapter.onUserItemClick = object : UsersListAdapter.OnUserItemClick {
            override fun onUserItemClick(dbModel: UserDbModel) {
                launchUserItemFragment(dbModel.id)
            }

        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.state.collect {
                    when (it) {
                        State.Initial -> {
                            binding.progressBarLoading.isVisible = false
                        }

                        State.Loading -> {
                            binding.progressBarLoading.isVisible = true
                        }

                        is State.Content -> {
                            binding.progressBarLoading.isVisible = false
                            usersListAdapter.submitList(it.usersList)
                        }

                    }
                }
            }
        }
    }

    private fun launchUserItemFragment(id: Int) {
        activity?.supportFragmentManager?.popBackStack()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.users_list_fragment, UserDetailsFragment().getInstance(id))
            ?.addToBackStack(null)
            ?.commit()
    }
}
