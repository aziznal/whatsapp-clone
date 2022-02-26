package com.example.whatsappclone.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.whatsappclone.models.Message

@Dao
interface MessageDao : BaseDao<Message> {
    @Query("SELECT * FROM messages WHERE chat_id = :chatId ORDER BY datetime ASC")
    fun getMessagesByChatId(chatId: String): LiveData<List<Message>>
}