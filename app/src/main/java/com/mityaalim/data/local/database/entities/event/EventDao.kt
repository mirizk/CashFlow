package com.mityaalim.data.local.database.entities.event

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEvents(eventEntity: List<EventEntity>)

    @Query("SELECT * FROM EventEntity")
    fun getAllEvents(): LiveData<List<EventEntity>>
}