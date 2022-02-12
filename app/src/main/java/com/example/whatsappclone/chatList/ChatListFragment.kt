package com.example.whatsappclone.chatList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.R
import com.example.whatsappclone.databinding.FragmentChatListBinding

private const val TAG = "ChatListFragment"

class ChatListFragment : Fragment() {

    private var _binding: FragmentChatListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        createViewModel()

        setupChatList()

        return binding.root
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
        binding.viewModel = ViewModelProvider(this)[ChatListFragmentViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}