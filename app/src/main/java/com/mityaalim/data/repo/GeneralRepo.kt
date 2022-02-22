package com.mityaalim.data.repo

import androidx.lifecycle.LiveData
import com.mityaalim.ui.main.events.EventItem

interface GeneralRepo {
    fun getAllEvents(): LiveData<List<EventItem>>
}