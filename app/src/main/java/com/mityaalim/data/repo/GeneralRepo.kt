package com.mityaalim.data.repo

import androidx.lifecycle.LiveData
import com.mityaalim.data.general.Academy
import com.mityaalim.data.general.Budget
import com.mityaalim.data.general.Event
import com.mityaalim.data.general.Investment
import com.mityaalim.ui.main.investment.ServiceItem
import kotlinx.coroutines.flow.Flow

interface GeneralRepo {
    suspend fun saveBudget(budget: Budget)
    fun getAllBudget(): Flow<List<Budget>>
    fun deleteBudget(budget: Budget)
    fun getEventsLiveData(): LiveData<List<Event>?>
    fun getInvestmentsLiveData(): LiveData<List<Investment>?>
    fun getAcademyLiveData(): LiveData<List<Academy>?>
}