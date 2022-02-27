package com.example.whatsappclone.fragments.addNewChat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R

private const val TAG = "NewChatFragment"

class AddNewChatFragment : Fragment() {

    val viewModel by lazy {
        createViewModel()
    }

    lateinit var view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_new_chat_list, container, false) as RecyclerView

        setupViewAdapter()

        return view
    }

    private fun setupViewAdapter() {
        val adapter = AddNewChatAdapter()

        view.adapter = adapter

        // Set adapter to update when contact list updates
        viewModel.allContacts.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun createViewModel(): AddNewChatFragmentViewModel {
        val viewModelFactory = AddNewChatFragmentViewModelFactory()
        return ViewModelProvider(this, viewModelFactory)[AddNewChatFragmentViewModel::class.java]
    }
}