package com.example.whatsappclone.models

data class Contact(
    val id: String,
    val contactInformation: ContactInformation,
    var chat: Chat?
)

data class ContactInformation(
    val fullName: String,
    val status: String,
    val phoneNumber: String,
    val isBlocked: Boolean,
)