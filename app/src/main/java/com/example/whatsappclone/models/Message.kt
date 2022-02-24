package com.example.whatsappclone.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

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
    val id: Int,

    @ColumnInfo(name = "body")
    val body: String,

    @ColumnInfo(name = "datetime")
    val datetime: String,

    @ColumnInfo(name = "chat_id", index = true)
    val chatId: Int
)