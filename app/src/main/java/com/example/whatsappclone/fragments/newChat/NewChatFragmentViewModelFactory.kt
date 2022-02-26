package com.example.whatsappclone.fragments.newChat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatsappclone.data.WhatsappCloneDatabase

class NewChatFragmentViewModelFactory(val database: WhatsappCloneDatabase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WhatsappCloneDatabase::class.java).newInstance(database)
    }
}