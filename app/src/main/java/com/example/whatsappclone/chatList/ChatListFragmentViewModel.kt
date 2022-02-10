package com.example.whatsappclone.chatList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "ChatFragmentViewModel"

class ChatListFragmentViewModel constructor() : ViewModel() {
    private var _foo = MutableLiveData<String>("Foo")
    val foo: LiveData<String>
        get() = _foo

    init {
        Log.d(TAG, "ChatFragmentViewModel has been created")
    }

    fun getTime(): String {
        _foo.value = System.currentTimeMillis().toString()
        return System.currentTimeMillis().toString()
    }
}