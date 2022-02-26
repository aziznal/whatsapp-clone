package com.example.whatsappclone.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.whatsappclone.models.Contact
import com.example.whatsappclone.models.ContactWithLastMessage

@Dao
interface ContactDao : BaseDao<Contact> {
    @Query("SELECT * FROM contacts ORDER BY full_name ASC")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query(
        """
        SELECT * FROM contacts
            INNER JOIN chats ON contacts.id = chats.other_person_contact_id
            INNER JOIN messages ON chats.id = messages.chat_id
            ORDER BY datetime DESC
            LIMIT 1
        """
    )
    fun getContactsWithLastChatMessage(): LiveData<List<ContactWithLastMessage>>
}