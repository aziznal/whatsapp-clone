package com.example.whatsappclone.chat

import android.view.MenuItem
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {

    private var isBlocked: Boolean = false

    fun toggleBlockedStatus(menuItem: MenuItem): Boolean {
        isBlocked = !isBlocked
        menuItem.isChecked = isBlocked
        return true
    }

}