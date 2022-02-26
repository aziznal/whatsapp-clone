package com.example.whatsappclone.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Message

@Dao
interface ChatDao : BaseDao<Chat> {
    @Query("SELECT * FROM chats")
    fun getAllChats(): LiveData<List<Chat>>

    @Query("SELECT * FROM chats WHERE other_person_contact_id = :contactId")
    suspend fun getChatByContactId(contactId: String): Chat?

    @Query(
        """
            SELECT * FROM messages
                WHERE messages.chat_id == :chatId
                ORDER BY datetime ASC
            """
    )
    fun getChatMessagesByChatId(chatId: String): LiveData<List<Message>>

    @Query("""DELETE FROM chats""")
    suspend fun clearAllChats()
}