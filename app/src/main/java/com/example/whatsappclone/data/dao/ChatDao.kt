package com.example.whatsappclone.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.whatsappclone.models.Chat

@Dao
interface ChatDao : BaseDao<Chat> {
    @Query("SELECT * FROM chats WHERE other_person_contact_id = :contactId")
    fun getChatByContactId(contactId: String): Chat
}