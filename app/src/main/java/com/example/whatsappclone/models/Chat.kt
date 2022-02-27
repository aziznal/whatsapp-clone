package com.example.whatsappclone.models

data class Chat(
    val id: String,
    var messages: MutableList<Message> = mutableListOf()
)