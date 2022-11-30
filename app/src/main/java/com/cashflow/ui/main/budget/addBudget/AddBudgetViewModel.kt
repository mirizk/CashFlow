package com.cashflow.ui.main.budget.addBudget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cashflow.data.enums.BudgetType
import com.cashflow.data.general.Budget
import com.cashflow.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddBudgetViewModel @Inject constructor(private val repo: GeneralRepo) : ViewModel() {

    fun saveNewBudget(type: BudgetType, name: String, sum: Int, date: Date) {
        viewModelScope.launch(Dispatchers.IO) {
                repo.saveBudget(Budget(UUID.randomUUID().toString(), name, type, sum, date))
        }

    }
}