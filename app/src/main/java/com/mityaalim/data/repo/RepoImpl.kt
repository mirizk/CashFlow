package com.mityaalim.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mityaalim.data.local.prefs.Prefs
import com.mityaalim.ui.main.events.EventItem
import javax.inject.Inject

class RepoImpl @Inject constructor(private val prefs: Prefs) : GeneralRepo {

    override fun getAllEvents(): LiveData<List<EventItem>> { //todo get the data from database
        val events = listOf(
            EventItem("1","כנס בוגרים", "פירוט ומידע על האירוע לדוגמא, פה נכנס מידע לגבי האירוע. כטטער", "22.08.22 18:30"),
            EventItem("2","אירוע 2", "כלכלה נכונה", "4.5.23 12:00"),
            EventItem("3","כנס בוגרים", "איקגטרא דקקג כטטער", "22.08.22 18:30"),
            EventItem("4","אירוע 2", "כלכלה נכונה", "4.5.23 12:00"),
            EventItem("5","כנס בוגרים", " דקקג כטטער", "22.08.22 18:30"),
            EventItem("6","אירוע 2", "כלכלה נכונה", "4.5.23 12:00"),
            EventItem("7","כנס ", "איקגטרא דקקג ", "22.08.22 18:30"),
            EventItem("8","אירוע 8", "כלכלה נכונה", "4.5.23 12:00"),
            EventItem("9","כנס בוגרים", "איקגטרא דקקג כטטער", "22.08.22 18:30"),
            EventItem("10","אירוע 10", "כלכלה נכונה", "4.5.23 12:00"),
            EventItem("11","כנס בוגרים11", " פירוט ומידע על האירוע לדוגמא, פה נכנס מידע לגבי האירוע", "22.08.22 18:00"),
            EventItem("12","אירוע 12", "כלכלה נכונה", "4.5.23 12:00"),)
        return MutableLiveData(events)
    }
}