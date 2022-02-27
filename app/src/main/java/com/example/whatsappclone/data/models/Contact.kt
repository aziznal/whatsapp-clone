package com.example.whatsappclone.data.models

data class Contact(
    val id: String,
    val contactInformation: ContactInformation,
    var chat: Chat?
) {
    fun addChat(chat: Chat) {
        this.chat = chat
    }

    fun removeChat(chatId: String) {
        this.chat = null
    }
}

data class ContactInformation(
    val fullName: String,
    val status: String,
    val phoneNumber: String,
    val isBlocked: Boolean,
)