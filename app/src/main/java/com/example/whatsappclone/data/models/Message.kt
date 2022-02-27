package com.example.whatsappclone.data.models

data class Message(
    val id: String,
    val body: String,
    val datetime: String,
    val isOwnMessage: Boolean,
    var hasBeenRead: Boolean
) {
    fun setAsRead() {
        hasBeenRead = true
    }
}