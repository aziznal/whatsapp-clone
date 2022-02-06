package com.example.whatsappclone.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.databinding.FragmentChatBinding

private const val TAG = "ChatFragment"

class MockChatData {
    val chatList = listOf<ChatItem>(
        ChatItem("John", "We should meet soon!"),
        ChatItem("Jane", "They said it works for them"),
        ChatItem("Pizza", "OK"),
        ChatItem("Mom", "sure"),
        ChatItem("John", "We should meet soon!"),
        ChatItem("Jane", "They said it works for them"),
        ChatItem("Pizza", "OK"),
        ChatItem("Mom", "sure"),
        ChatItem("John", "We should meet soon!"),
        ChatItem("Jane", "They said it works for them"),
        ChatItem("Pizza", "OK"),
        ChatItem("Mom", "sure"),
        ChatItem("John", "We should meet soon!"),
        ChatItem("Jane", "They said it works for them"),
        ChatItem("Pizza", "OK"),
        ChatItem("Mom", "sure"),
    ).toTypedArray()
}

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        createViewModel()

        setupChatList()

        return binding.root
    }

    private fun setupChatList() {
        val chatAdapter = ChatListAdapter(MockChatData().chatList)
        val layoutManager = LinearLayoutManager(context)

        binding.chatList.layoutManager = layoutManager
        binding.chatList.adapter = chatAdapter
    }

    private fun createViewModel() {
        binding.viewModel = ViewModelProvider(this)[ChatFragmentViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}