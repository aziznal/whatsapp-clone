package com.example.whatsappclone.chat

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.whatsappclone.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    val args: ChatFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.centeredText.text = "I should load the chat with id ${args.chatId.toString()}, but I don't have a database yet!"

        bindViewModel()

        return binding.root
    }

    private fun bindViewModel() {
        val viewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
        binding.viewModel = viewModel
    }

}