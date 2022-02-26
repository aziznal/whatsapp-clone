package com.example.whatsappclone.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.whatsappclone.models.Contact

@Dao
interface ContactDao : BaseDao<Contact> {
    @Query("SELECT * FROM contacts ORDER BY full_name ASC")
    fun getAllContacts(): LiveData<List<Contact>>
}