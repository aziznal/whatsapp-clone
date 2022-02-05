package com.example.whatsappclone.chat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.whatsappclone.databinding.FragmentChatBinding

private const val TAG = "ChatFragment"

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    private lateinit var chatFragmentViewModel: ChatFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)

        createViewModel()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun createViewModel() {
        chatFragmentViewModel = ViewModelProvider(this).get(ChatFragmentViewModel::class.java)
        binding.viewModel = chatFragmentViewModel

        Log.d(TAG, chatFragmentViewModel.foo.toString())
        Log.d(TAG, "View Model Created")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}