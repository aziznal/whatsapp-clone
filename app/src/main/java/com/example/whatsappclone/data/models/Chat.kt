package com.example.whatsappclone.data.models

data class Chat(
    val id: String,
    var messages: MutableList<Message> = mutableListOf()
)