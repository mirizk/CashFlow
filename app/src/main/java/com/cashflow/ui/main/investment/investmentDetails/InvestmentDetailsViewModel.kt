package com.cashflow.ui.main.investment.investmentDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.cashflow.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InvestmentDetailsViewModel @Inject constructor(
    repo: GeneralRepo,
    private val state: SavedStateHandle
    ) : ViewModel() {
    val service = repo.getInvestmentsLiveData().map {
        it?.firstOrNull{
            it.id == state.get<String>("investmentId")
        }
    }
}