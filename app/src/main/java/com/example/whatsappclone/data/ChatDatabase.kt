package com.example.whatsappclone.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whatsappclone.data.dao.ChatDao
import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Contact
import com.example.whatsappclone.models.Message

@Database(
    entities = [
        Contact::class,
        Chat::class,
        Message::class
    ],

    version = 1
)
abstract class ChatDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao

    companion object {
        private var INSTANCE: ChatDatabase? = null

        /**
         * Returns current instance of database if one exists. Otherwise, creates and returns a new instance.
         * */
        fun getDatabaseInstance(context: Context): ChatDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, ChatDatabase::class.java, "chat_database")
                            .build()
                }
            }

            return INSTANCE!!
        }
    }
}