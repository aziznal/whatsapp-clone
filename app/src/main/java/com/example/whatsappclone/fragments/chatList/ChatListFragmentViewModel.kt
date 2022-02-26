package com.example.whatsappclone.fragments.chatList

import androidx.lifecycle.ViewModel
import com.example.whatsappclone.data.WhatsappCloneDatabase
import com.example.whatsappclone.utils.SingleLiveEvent

private const val TAG = "ChatFragmentViewModel"

class ChatListFragmentViewModel(
    val database: WhatsappCloneDatabase
) : ViewModel() {

    val gotoNewChatScreen = SingleLiveEvent<Boolean>()

    fun onNewChatButtonClicked() {
        gotoNewChatScreen.value = true
    }
}
