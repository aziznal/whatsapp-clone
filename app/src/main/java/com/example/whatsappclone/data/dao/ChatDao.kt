package com.example.whatsappclone.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Message

@Dao
interface ChatDao : BaseDao<Chat> {
    @Query("SELECT * FROM chats WHERE other_person_contact_id = :contactId")
    fun getChatByContactId(contactId: String): Chat?

    @Query(
        """
            SELECT messages.body FROM chats
                INNER JOIN messages ON messages.chat_id
                WHERE id = :chatId
                ORDER BY datetime ASC
        """
    )
    fun getChatMessagesByChatId(chatId: String): LiveData<List<Message>>

    @Query("""DELETE FROM chats""")
    fun clearAllChats()
}