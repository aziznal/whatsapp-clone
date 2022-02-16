package com.example.whatsappclone.chatList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "ChatFragmentViewModel"

class ChatListFragmentViewModel : ViewModel() {

    private var _gotoNewChatScreenEvent = MutableLiveData(false)
    public val gotoNewChatScreenEvent: LiveData<Boolean>
        get() = _gotoNewChatScreenEvent

    fun onNewChatButtonClicked() {
        Log.d(TAG, "onNewChatButtonClicked: Clicked Fab")
        _gotoNewChatScreenEvent.value = true
    }


    fun completeGotoNewChatScreenEvent() {
        Log.d(TAG, "onNewChatButtonClicked: Handled Fab Click")
        _gotoNewChatScreenEvent.value = false
    }

}