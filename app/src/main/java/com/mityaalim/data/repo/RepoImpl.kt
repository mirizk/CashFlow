package com.mityaalim.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.mityaalim.data.general.Academy
import com.mityaalim.data.general.Budget
import com.mityaalim.data.general.Event
import com.mityaalim.data.general.Investment
import com.mityaalim.data.local.database.LocalDataSource
import com.mityaalim.data.local.prefs.Prefs
import com.mityaalim.data.remote.RemoteDataSource
import com.mityaalim.data.remote.toGeneralAcademyList
import com.mityaalim.data.remote.toGeneralEventsList
import com.mityaalim.data.remote.toGeneralInvestmentsList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val prefs: Prefs,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : GeneralRepo {

    override suspend fun saveBudget(budget: Budget) {
        localDataSource.insertBudget(budget)
    }

    override fun getAllBudget(): Flow<List<Budget>> {
        return localDataSource.getAllBudget()
    }

    override fun deleteBudget(budget: Budget) {
        localDataSource.deleteBudget(budget)
    }

    override fun getEventsLiveData(): LiveData<List<Event>?> {
        return remoteDataSource.getEventsLiveData().map {
            it?.toGeneralEventsList()
        }
    }

    override fun getInvestmentsLiveData(): LiveData<List<Investment>?> {
        return remoteDataSource.getInvestmentsLiveData().map {
            it?.toGeneralInvestmentsList()
        }
    }

    override fun getAcademyLiveData(): LiveData<List<Academy>?> {
        return remoteDataSource.getAcademyLiveData().map {
            it?.toGeneralAcademyList()
        }
    }
}