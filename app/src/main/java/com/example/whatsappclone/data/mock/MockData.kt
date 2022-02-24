package com.example.whatsappclone.data.mock

import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Contact
import com.example.whatsappclone.models.Message

class MockData {
    companion object {
        val mockContacts = listOf(
            Contact(
                id = 1,
                fullName = "John Doe",
                status = "Available",
                phoneNumber = "8726187745",
                isBlocked = false
            ),
            Contact(
                id = 2,
                fullName = "Jane Doe",
                status = "Urgent Calls Only",
                phoneNumber = "3163462865",
                isBlocked = false
            ),
        ).toTypedArray()

        val mockChats = listOf(
            Chat(
                id = 1,
                otherPersonContactId = mockContacts[0].id
            ),
            Chat(
                id = 2,
                otherPersonContactId = mockContacts[1].id
            ),
        ).toTypedArray()

        val mockMessages = listOf(
            Message(
                id = 1,
                body = "I know what you did last summer",
                datetime = "16:41",
                chatId = mockChats[0].id
            ),
            Message(
                id = 2,
                body = "I still know what you did last summer",
                datetime = "16:43",
                chatId = mockChats[0].id
            ),
            Message(
                id = 3,
                body = "I will always know what you did last summer",
                datetime = "16:45",
                chatId = mockChats[0].id
            ),

            Message(
                id = 4,
                body = "I know what you did last summer",
                datetime = "16:41",
                chatId = mockChats[1].id
            ),
            Message(
                id = 5,
                body = "I still know what you did last summer",
                datetime = "16:43",
                chatId = mockChats[1].id
            ),
            Message(
                id = 6,
                body = "I will always know what you did last summer",
                datetime = "16:45",
                chatId = mockChats[1].id
            ),
        ).toTypedArray()
    }
}