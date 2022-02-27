package com.example.whatsappclone.data.mock

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Contact
import com.example.whatsappclone.models.ContactInformation
import com.example.whatsappclone.models.Message

class MockData {
    companion object {
        private val contacts = listOf<Contact>(
            Contact(
                id = "contact1",
                contactInformation = ContactInformation(
                    fullName = "John Doe",
                    status = "Available",
                    phoneNumber = "+90153489789",
                    isBlocked = false
                ),
                chat = Chat(
                    id = "contact1Chat",
                    messages = mutableListOf<Message>(
                        Message(
                            id = "contact1ChatMessage1",
                            body = "This is this chat's first message!",
                            datetime = "1970-01-01TZ00:00:00",
                            isOwnMessage = true,
                            hasBeenRead = false
                        )
                    )
                )
            ),

            Contact(
                id = "contact2",
                contactInformation = ContactInformation(
                    fullName = "Jane Doe",
                    status = "Urgent Calls Only",
                    phoneNumber = "+00457546145",
                    isBlocked = false
                ),
                chat = Chat(
                    id = "contact2Chat",
                    messages = mutableListOf<Message>(
                        Message(
                            id = "contact2ChatMessage1",
                            body = "Let's get pizza tonight",
                            datetime = "1970-01-01TZ00:00:00",
                            isOwnMessage = true,
                            hasBeenRead = true
                        ),
                        Message(
                            id = "contact2ChatMessage2",
                            body = "That sounds good",
                            datetime = "1970-01-01TZ00:00:00",
                            isOwnMessage = false,
                            hasBeenRead = true
                        )
                    )
                )
            ),

            ).toTypedArray().toMutableList()

        fun getContacts(): MutableLiveData<List<Contact>> {
            return MutableLiveData<List<Contact>>(contacts)
        }

        private fun getContactById(contactId: String): Contact {
            return contacts.find { it.id == contactId }
                ?: throw Resources.NotFoundException("Couldn't find contact with id $contactId")
        }

        fun addContact(contact: Contact) {
            contacts.add(contact)
        }

        fun removeContact(contactId: String) {
            contacts.removeIf {
                it.id == contactId
            }
        }

        fun addChat(contactId: String, chat: Chat) {
            val contact = getContactById(contactId)
            contact.chat = chat
        }

        fun removeChat(contactId: String, chatId: String) {
            val contact = getContactById(contactId)
            contact.chat = null
        }

        fun addMessage(contactId: String, message: Message) {
            val contact = getContactById(contactId)
            contact.chat?.messages?.add(message)
        }

        fun removeMessage(contactId: String, messageId: String) {
            val contact = getContactById(contactId)
            contact.chat?.messages?.removeIf { it.id == messageId }
        }
    }
}