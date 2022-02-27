package com.example.whatsappclone.models

data class Message(
    val id: String,
    val body: String,
    val datetime: String,
    val isOwnMessage: Boolean,
    val hasBeenRead: Boolean
)