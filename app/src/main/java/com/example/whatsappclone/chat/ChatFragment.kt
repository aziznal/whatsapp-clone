package com.example.whatsappclone.chat

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.whatsappclone.R
import com.example.whatsappclone.databinding.FragmentChatBinding

private const val TAG = "ChatFragment"

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

        binding.centeredText.text =
            "I should load the chat with id ${args.chatId.toString()}, but I don't have a database yet!"

        setHasOptionsMenu(true)

        bindViewModel()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_chat, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_block_button -> false
            else -> false
        }
    }

    private fun bindViewModel() {
        val viewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
        binding.viewModel = viewModel
    }

}