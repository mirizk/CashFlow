package com.mityaalim.data.remote.model

import java.util.*

class EventItem(
    val eventId: String = UUID.randomUUID().toString(),
    val title: String? = null,
    val description: String? = null,
    val time: String? = null
)