package com.mityaalim.data.repo

import androidx.lifecycle.LiveData
import com.mityaalim.data.general.Budget
import com.mityaalim.ui.main.events.EventItem
import kotlinx.coroutines.flow.Flow

interface GeneralRepo {
    fun getAllEvents(): LiveData<List<EventItem>>

    suspend fun saveBudget(budget: Budget)
    fun getAllBudget(): Flow<List<Budget>>
    fun deleteBudget(budget: Budget)
}