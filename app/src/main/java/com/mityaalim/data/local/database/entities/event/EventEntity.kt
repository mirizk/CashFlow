package com.mityaalim.data.local.database.entities.event

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EventEntity (
    @PrimaryKey val eventId: String,
    val title: String?,
    val description: String?,
    val time: String?
)
