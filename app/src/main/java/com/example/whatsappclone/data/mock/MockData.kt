package com.example.whatsappclone.data.mock

import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Contact
import com.example.whatsappclone.models.Message

class MockData {
    companion object {
        val mockContacts = listOf(
            Contact(
                id = "Contact1",
                fullName = "John Doe",
                status = "Available",
                phoneNumber = "8726187745",
                isBlocked = false
            ),
            Contact(
                id = "Contact2",
                fullName = "Jane Doe",
                status = "Urgent Calls Only",
                phoneNumber = "3163462865",
                isBlocked = false
            ),
        ).toTypedArray()

        val mockChats = listOf(
            Chat(
                id = "Chat1",
                otherPersonContactId = mockContacts[0].id
            ),
            Chat(
                id = "Chat2",
                otherPersonContactId = mockContacts[1].id
            ),
        ).toTypedArray()

        val mockMessages = listOf(
            Message(
                id = "Message1",
                body = "I know what you did last summer",
                datetime = "16:41",
                chatId = mockChats[0].id,
                isOwnMessage = false,
                hasBeenRead = false
            ),
            Message(
                id = "Message2",
                body = "I still know what you did last summer",
                datetime = "16:43",
                chatId = mockChats[0].id,
                isOwnMessage = false,
                hasBeenRead = false
            ),
            Message(
                id = "Message3",
                body = "I will always know what you did last summer",
                datetime = "16:45",
                chatId = mockChats[0].id,
                isOwnMessage = false,
                hasBeenRead = false
            ),

            Message(
                id = "Message4",
                body = "I know what you did last summer",
                datetime = "16:41",
                chatId = mockChats[1].id,
                isOwnMessage = false,
                hasBeenRead = false
            ),
            Message(
                id = "Message5",
                body = "I still know what you did last summer",
                datetime = "16:43",
                chatId = mockChats[1].id,
                isOwnMessage = false,
                hasBeenRead = false
            ),
            Message(
                id = "Message6",
                body = "I will always know what you did last summer",
                datetime = "16:45",
                chatId = mockChats[1].id,
                isOwnMessage = false,
                hasBeenRead = false
            ),
        ).toTypedArray()
    }
}