package com.mityaalim.data.remote.model

import com.google.firebase.Timestamp
import java.util.*

class EventItem(
    val eventId: String = UUID.randomUUID().toString(),
    val title: String? = null,
    val description: String? = null,
    val time: Timestamp? = null,
    val location: String? = null
)