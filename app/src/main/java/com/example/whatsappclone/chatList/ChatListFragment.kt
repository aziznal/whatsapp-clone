package com.example.whatsappclone.chatList

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.R
import com.example.whatsappclone.databinding.FragmentChatListBinding

private const val TAG = "ChatListFragment"


class ChatListFragment : Fragment() {

    private var _binding: FragmentChatListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ChatListFragmentViewModel

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

    private fun handleViewModelObservables() {
        viewModel.gotoNewChatScreenEvent.observe(
            viewLifecycleOwner
        ) { eventValue ->
            if (eventValue) {
                findNavController().navigate(R.id.action_chatListFragment_to_newChatFragment)
                viewModel.completeGotoNewChatScreenEvent()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    private fun setupChatList() {
        val chatAdapter = ChatListAdapter(MockChatData().chatList) {
            findNavController().navigate(
                ChatListFragmentDirections.actionChatListFragmentToChatFragment(
                    "123456"
                )
            )
        }

        val layoutManager = LinearLayoutManager(context)

        binding.chatList.layoutManager = layoutManager
        binding.chatList.adapter = chatAdapter
    }

    private fun createViewModel() {
        viewModel = ViewModelProvider(this)[ChatListFragmentViewModel::class.java]
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}