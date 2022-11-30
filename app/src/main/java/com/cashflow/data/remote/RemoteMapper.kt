package com.cashflow.data.remote

import com.cashflow.data.general.Academy
import com.cashflow.data.general.Event
import com.cashflow.data.general.Investment

fun List<com.cashflow.data.remote.model.EventItem>.toGeneralEventsList(): List<Event> {
    return map {
        Event(it.eventId, it.title, it.description, it.time, it.location)
    }
}
fun List<com.cashflow.data.remote.model.InvestmentsItem>.toGeneralInvestmentsList(): List<Investment> {
    return map {
        Investment(it.id, it.title, it.description, it.price, it.imageUrl)
    }
}
fun List<com.cashflow.data.remote.model.AcademyItem>.toGeneralAcademyList(): List<Academy> {
    return map {
        Academy(it.id, it.title, it.duration, it.imageUrl, it.videoUrl)
    }
}