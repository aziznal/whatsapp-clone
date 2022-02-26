package com.example.whatsappclone.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.whatsappclone.models.Contact

@Dao
interface ContactDao : BaseDao<Contact> {
    @Insert
    fun insertContacts(vararg contacts: Contact)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>
}