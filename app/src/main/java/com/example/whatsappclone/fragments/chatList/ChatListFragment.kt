package com.example.whatsappclone.fragments.chatList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.whatsappclone.R
import com.example.whatsappclone.adapters.ChatListAdapter
import com.example.whatsappclone.databinding.FragmentChatListBinding
import com.example.whatsappclone.models.Contact

private const val TAG = "ChatListFragment"

class ChatListFragment : Fragment() {
    private var _binding: FragmentChatListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ChatListFragmentViewModel

    private val chatAdapter by lazy {
        createChatListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        setHasOptionsMenu(true)

        createViewModel()

        handleViewModelObservables()

        setupChatList()

        return binding.root
    }

    private fun createChatListAdapter(): ChatListAdapter {
        val adapter = ChatListAdapter() {
            onListedChatClicked(it)
        }

        viewModel.contactList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return adapter
    }

    private fun onListedChatClicked(it: Contact) {
        findNavController().navigate(
            ChatListFragmentDirections.actionChatListFragmentToChatFragment(
                it.id
            )
        )
    }

    private fun handleViewModelObservables() {
        viewModel.gotoNewChatScreen.observe(viewLifecycleOwner) {
            gotoNewChatScreen()
        }
    }

    private fun gotoNewChatScreen() {
        findNavController().navigate(
            ChatListFragmentDirections.actionChatListFragmentToNewChatFragment()
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    private fun setupChatList() {
        binding.chatList.adapter = chatAdapter
    }

    private fun createViewModel() {
        val viewModelFactory = ChatListFragmentViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[ChatListFragmentViewModel::class.java]
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}