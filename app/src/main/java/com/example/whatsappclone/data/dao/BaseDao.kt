package com.example.whatsappclone.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/**
 * Base interface used for all other DAOs. Includes basic CRUD operations.
 * */
interface BaseDao<T> {
    @Insert
    fun insert(vararg entity: T)

    @Update
    fun update(vararg entity: T)

    @Delete
    fun delete(vararg entityId: String)
}