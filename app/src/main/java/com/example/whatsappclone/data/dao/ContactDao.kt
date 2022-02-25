package com.example.whatsappclone.data.dao

import androidx.room.*
import com.example.whatsappclone.models.Contact

@Dao
interface ContactDao : BaseDao<Contact> {
    @Query("SELECT * FROM contacts ORDER BY full_name ASC")
    fun getAllContacts(): List<Contact>
}