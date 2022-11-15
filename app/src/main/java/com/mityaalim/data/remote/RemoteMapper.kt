package com.mityaalim.data.remote

import com.mityaalim.data.general.Event

fun List<com.mityaalim.data.remote.model.EventItem>.toGeneralEventsList(): List<Event> {
    return map {
        Event(it.eventId, it.title, it.description, it.time, it.location)
    }
}
