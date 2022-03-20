package com.mityaalim.data.local.database

import com.mityaalim.data.general.Budget
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
}