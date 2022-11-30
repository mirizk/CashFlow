package com.cashflow.data.repo

import androidx.lifecycle.LiveData
import com.cashflow.data.general.Academy
import com.cashflow.data.general.Budget
import com.cashflow.data.general.Event
import com.cashflow.data.general.Investment
import kotlinx.coroutines.flow.Flow

interface GeneralRepo {
    suspend fun saveBudget(budget: Budget)
    fun getAllBudget(): Flow<List<Budget>>
    fun deleteBudget(budget: Budget)
    fun getEventsLiveData(): LiveData<List<Event>?>
    fun getInvestmentsLiveData(): LiveData<List<Investment>?>
    fun getAcademyLiveData(): LiveData<List<Academy>?>
}