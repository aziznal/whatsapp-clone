package com.example.whatsappclone.fragments.chatList

import androidx.lifecycle.ViewModel
import com.example.whatsappclone.data.mock.MockData
import com.example.whatsappclone.utils.SingleLiveEvent

private const val TAG = "ChatFragmentViewModel"

class ChatListFragmentViewModel : ViewModel() {

    val contactList = MockData.getContacts()
    val gotoNewChatScreen = SingleLiveEvent<Boolean>()

    fun onNewChatButtonClicked() {
        gotoNewChatScreen.value = true
    }
}
