package com.example.whatsappclone.data.models

data class Chat(
    val id: String,
    var messages: MutableList<Message> = mutableListOf()
) {

    fun addMessage(message: Message) {
        this.messages.add(message)
    }

    fun removeMessage(messageId: String) {
        this.messages.removeIf { it.id == messageId }
    }
}