package com.example.whatsappclone.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ChatItem::class,
            parentColumns = arrayOf("id"),  // chat id
            childColumns = arrayOf("id"),   // message id
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "body") val body: String,
    @ColumnInfo(name = "datetime") val datetime: Date
)

@Entity(tableName = "chats")
data class ChatItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "other_party_name") val otherPartyName: String,
) : Serializable
