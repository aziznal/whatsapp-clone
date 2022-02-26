package com.example.whatsappclone.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.whatsappclone.data.dao.ChatDao
import com.example.whatsappclone.data.dao.ContactDao
import com.example.whatsappclone.data.dao.MessageDao
import com.example.whatsappclone.data.mock.MockData
import com.example.whatsappclone.models.Chat
import com.example.whatsappclone.models.Contact
import com.example.whatsappclone.models.Message
import com.example.whatsappclone.utils.ioThread
import kotlinx.coroutines.coroutineScope


private const val TAG = "WhatsappCloneDatabase"

/**
 * Database responsible for CRUD operations on contacts, chats, and their messages.
 *
 * Should this be split up into 3 different databases?
 * Is it okay to keep multiple DAOs in the same databases?
 * */
@Database(
    entities = [
        Contact::class,
        Chat::class,
        Message::class
    ],
    version = 1
)
abstract class WhatsappCloneDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun chatDao(): ChatDao
    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: WhatsappCloneDatabase? = null

        /**
         * Returns current instance of database if one exists. Otherwise, creates and returns a new instance.
         * */
        fun getDatabaseInstance(context: Context): WhatsappCloneDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context,
                            WhatsappCloneDatabase::class.java,
                            "whatsapp_clone_database.db"
                        )
                            // This callback pre-populates the database with data
//                            .addCallback(object : Callback() {
//                                override fun onCreate(db: SupportSQLiteDatabase) {
//                                    super.onCreate(db)
//
//                                    Log.d(TAG, "getDatabaseInstance: now I'm here")
//
//                                    ioThread {
//                                        Log.d(TAG, "onCreate: Adding data to database")
//                                        Log.d(TAG, "onCreate: ${MockData.mockContacts}")
//                                        getDatabaseInstance(context).contactDao()
//                                            .insertContacts(*MockData.mockContacts)
//                                    }
//                                }
//                            })
                            .build()
                }
            }

            return INSTANCE!!
        }
    }
}