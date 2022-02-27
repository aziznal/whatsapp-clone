package com.example.whatsappclone.data.mock

import androidx.lifecycle.MutableLiveData
import com.example.whatsappclone.data.models.Chat
import com.example.whatsappclone.data.models.Contact
import com.example.whatsappclone.data.models.ContactInformation
import com.example.whatsappclone.data.models.Message

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

        fun addContact(contact: Contact) {
            contacts.add(contact)
        }

        fun removeContact(contactId: String) {
            contacts.removeIf {
                it.id == contactId
            }
        }
    }
}