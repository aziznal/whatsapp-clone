package com.example.whatsappclone.fragments.chatList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappclone.data.WhatsappCloneDatabase
import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.utils.SingleLiveEvent
import kotlinx.coroutines.launch

private const val TAG = "ChatFragmentViewModel"

class ChatListFragmentViewModel(
    val database: WhatsappCloneDatabase
) : ViewModel() {

    val chatList = database.chatDao().getAllChats()
    val gotoNewChatScreen = SingleLiveEvent<Boolean>()

    fun onNewChatButtonClicked() {
        gotoNewChatScreen.value = true

        viewModelScope.launch {
            database.chatDao().insert(Chat(id = "manualchat2", "ManuallyCreatedContact1"))
        }
    }
}
