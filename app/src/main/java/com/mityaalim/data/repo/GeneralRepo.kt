package com.mityaalim.data.repo

import androidx.lifecycle.LiveData
import com.mityaalim.data.general.Budget
import com.mityaalim.data.general.Event
import com.mityaalim.ui.main.events.EventItem
import com.mityaalim.ui.main.investment.ServiceItem
import kotlinx.coroutines.flow.Flow

interface GeneralRepo {
    suspend fun fetchAllEvents()
    fun getAllEvents(): LiveData<List<Event>>

    suspend fun saveBudget(budget: Budget)
    fun getAllBudget(): Flow<List<Budget>>
    fun deleteBudget(budget: Budget)
    fun getAllServices(): LiveData<List<ServiceItem>>
}