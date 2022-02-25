package com.example.whatsappclone.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: String,

    @ColumnInfo(name = "full_name")
    val fullName: String,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,

    @ColumnInfo(name = "is_blocked")
    val isBlocked: Boolean
)

data class ContactWithLastMessage(
    val id: String,
    val fullName: String,
    val status: String,
    val phoneNumber: String,
    val isBlocked: Boolean,
    val lastMessage: Message
)