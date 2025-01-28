package com.example.usersapp.screens.userDetailsScreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.usersapp.R
import com.example.usersapp.UsersApp
import com.example.usersapp.databinding.FragmentUserDetailsBinding
import com.example.usersapp.di.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private val component by lazy {
        (requireActivity().application as UsersApp).component
    }

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding: FragmentUserDetailsBinding
        get() = _binding ?: throw RuntimeException("UserDetailsFragment is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UserDetailsViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getItem = getItemById()
        lifecycleScope.launch {
            viewModel.getUser(getItem).collect {
                binding.tvName.text = it.name
                binding.tvUsername.text = it.username
                binding.tvEmail.text = it.email
                binding.tvPhone.text = it.phone
                binding.tvAddress.text = it.addressCity
                binding.tvWebsite.text = it.website
                binding.tvCompany.text = it.companyName
            }
        }

    }

    private fun getItemById(): Int {
        return requireArguments().getInt(EXTRA_ID_KEY, DEFAULT_ID)
    }

    fun getInstance(id: Int): Fragment {
        return UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putInt(EXTRA_ID_KEY, id)
            }
        }
    }

    companion object {
        private const val EXTRA_ID_KEY = "id_key"
        private const val DEFAULT_ID = 0
    }
}
