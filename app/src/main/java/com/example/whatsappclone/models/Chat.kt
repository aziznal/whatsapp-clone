package com.example.whatsappclone.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "chats",
    foreignKeys = [
        ForeignKey(
            entity = Contact::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("other_person_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Chat(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "other_person_contact_id", index = true)
    val otherPersonContactId: Int,
)