package com.example.whatsappclone.fragments.newChat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.data.WhatsappCloneDatabase

private const val TAG = "NewChatFragment"

class NewChatFragment : Fragment() {

    val viewModel by lazy {
        createViewModel()
    }

    val database by lazy {
        WhatsappCloneDatabase.getDatabaseInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_chat_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val adapter = NewChatCandidateRecyclerViewAdapter()

            view.adapter = adapter

            viewModel.allContacts.observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        }

        return view
    }

    private fun createViewModel(): NewChatFragmentViewModel {
        val viewModelFactory = NewChatFragmentViewModelFactory(database)
        return ViewModelProvider(this, viewModelFactory)[NewChatFragmentViewModel::class.java]
    }
}