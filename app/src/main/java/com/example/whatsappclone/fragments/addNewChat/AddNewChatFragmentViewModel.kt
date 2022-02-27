package com.example.whatsappclone.fragments.addNewChat

import androidx.lifecycle.ViewModel
import com.example.whatsappclone.data.WhatsappCloneDatabase

private const val TAG = "ChatFragmentViewModel"

class AddNewChatFragmentViewModel(
    val database: WhatsappCloneDatabase
) : ViewModel() {
    val allContacts = database.contactDao().getAllContacts()
}
