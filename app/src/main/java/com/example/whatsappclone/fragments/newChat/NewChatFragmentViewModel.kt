package com.example.whatsappclone.fragments.newChat

import androidx.lifecycle.ViewModel
import com.example.whatsappclone.data.WhatsappCloneDatabase

private const val TAG = "ChatFragmentViewModel"

class NewChatFragmentViewModel(
    val database: WhatsappCloneDatabase
) : ViewModel() {
    val allContacts = database.contactDao().getAllContacts()
}
