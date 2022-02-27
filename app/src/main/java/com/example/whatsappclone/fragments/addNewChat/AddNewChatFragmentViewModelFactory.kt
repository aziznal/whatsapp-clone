package com.example.whatsappclone.fragments.addNewChat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatsappclone.data.WhatsappCloneDatabase

class AddNewChatFragmentViewModelFactory(val database: WhatsappCloneDatabase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WhatsappCloneDatabase::class.java).newInstance(database)
    }
}