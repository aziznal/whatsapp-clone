package com.example.whatsappclone.chat

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "ChatFragmentViewModel"

class ChatFragmentViewModel constructor() : ViewModel() {
    public var foo = "Hello Foo"

    init {
        Log.d(TAG, "ChatFragmentViewModel has been created")
    }
}