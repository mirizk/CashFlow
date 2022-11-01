package com.mityaalim.data.local.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.mityaalim.data.general.Budget
import com.mityaalim.data.general.Event
import com.mityaalim.data.local.toGeneralModel
import com.mityaalim.data.local.toLocalEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val database: MityaalimDatabase) {
    fun insertBudget(budget: Budget){
        database.budgetDao().insertBudget(budget.toLocalEntity())
    }

    fun deleteBudget(budget: Budget){
        database.budgetDao().deleteBudget(budget.toLocalEntity())
    }

    fun getAllBudget(): Flow<List<Budget>>{
        return database.budgetDao().getAllBudget().map {
            it.map { it.toGeneralModel() }
        }
    }

    suspend fun insertAllEvents(events: List<Event>) {
        database.eventDao().insertAllEvents(events.map{ it.toLocalEntity()})
    }

    fun getAllEvents() :LiveData<List<Event>>{
        return database.eventDao().getAllEvents().map {
            it.map {
                it.toGeneralModel()
            }
        }
    }
}