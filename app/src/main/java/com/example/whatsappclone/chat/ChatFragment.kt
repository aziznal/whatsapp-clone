package com.example.whatsappclone.chat

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.whatsappclone.R
import com.example.whatsappclone.databinding.FragmentChatBinding

private const val TAG = "ChatFragment"

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    private var _viewModel: ChatViewModel? = null
    private val viewModel get() = _viewModel!!

    private val args: ChatFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupBindingAndViewModel(inflater, container)

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        setAboutText()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_chat, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_block_switch -> viewModel.toggleBlockedStatus(item)
            else -> false
        }
    }

    private fun setupBindingAndViewModel(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(this)[ChatViewModel::class.java]

        bindViewModel()
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
    }

    private fun setAboutText() {
        binding.centeredText.text = getString(R.string.should_load_chat_text, args.chatId)
    }

}