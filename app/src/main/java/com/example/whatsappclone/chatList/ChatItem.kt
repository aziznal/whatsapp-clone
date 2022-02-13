package com.example.whatsappclone.chatList

import java.io.Serializable

// TODO: extend model. Maybe make more models

// TODO: implement Database

data class ChatItem(val chatName: String, val chatLastMessage: String) : Serializable
