package com.example.whatsappclone.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Chat::class,
            parentColumns = arrayOf("id"),  // chat id
            childColumns = arrayOf("chat_id"),   // chat id
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: String,

    @ColumnInfo(name = "chat_id", index = true)
    val chatId: String,

    @ColumnInfo(name = "body")
    val body: String,

    @ColumnInfo(name = "datetime")
    val datetime: String,

    @ColumnInfo(name = "is_own_message")
    val isOwnMessage: Boolean,

    @ColumnInfo(name = "has_been_read")
    val hasBeenRead: Boolean
)