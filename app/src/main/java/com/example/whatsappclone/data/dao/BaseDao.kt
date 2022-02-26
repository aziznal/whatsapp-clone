package com.example.whatsappclone.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/**
 * Base interface used for all other DAOs. Includes basic CRUD operations.
 * */
interface BaseDao<T> {
    @Insert
    suspend fun insert(vararg entity: T)

    @Update
    suspend fun update(vararg entity: T)

    @Delete
    suspend fun delete(vararg entity: T)
}