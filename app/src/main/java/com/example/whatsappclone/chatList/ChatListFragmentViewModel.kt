package com.example.whatsappclone.chatList

import SingleShotEvent
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.atomic.AtomicBoolean

private const val TAG = "ChatFragmentViewModel"

class ChatListFragmentViewModel : ViewModel() {

    private var _eventEmitter = SingleShotEvent<Events>()
    val eventEmitter: LiveData<Events> get() = _eventEmitter

    fun onNewChatButtonClicked() {
        Log.d(TAG, "onNewChatButtonClicked: Clicked Fab")

        _eventEmitter.setValue(Events.GotoNewChatScreenEvent)
    }

    sealed class Events {
        object GotoNewChatScreenEvent : Events()
    }
}
