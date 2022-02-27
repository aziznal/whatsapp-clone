package com.example.whatsappclone.fragments.addNewChat.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddNewChatFragmentViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}