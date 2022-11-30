package com.cashflow.data.local.database

import com.cashflow.data.general.Budget
import com.cashflow.data.local.toGeneralModel
import com.cashflow.data.local.toLocalEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val database: CashFlowDatabase) {
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