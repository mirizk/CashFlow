package com.mityaalim.data.remote

import com.mityaalim.data.general.Event
import com.mityaalim.data.general.Investment

fun List<com.mityaalim.data.remote.model.EventItem>.toGeneralEventsList(): List<Event> {
    return map {
        Event(it.eventId, it.title, it.description, it.time, it.location)
    }
}
fun List<com.mityaalim.data.remote.model.InvestmentsItem>.toGeneralInvestmentsList(): List<Investment> {
    return map {
        Investment(it.id, it.title, it.description, it.price, it.imageUrl)
    }
}