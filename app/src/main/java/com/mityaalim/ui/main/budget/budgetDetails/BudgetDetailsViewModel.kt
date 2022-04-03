package com.mityaalim.ui.main.budget.budgetDetails

import androidx.lifecycle.*
import com.mityaalim.data.general.Budget
import com.mityaalim.data.repo.GeneralRepo
import com.mityaalim.ui.main.budget.getStringMonth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BudgetDetailsViewModel @Inject constructor(val repo: GeneralRepo, state: SavedStateHandle) :
    ViewModel() {
    fun deleteBudget(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            allBudgets.value?.firstOrNull { it.id == id }?.let { repo.deleteBudget(it) }
        }
    }

    private val allBudgets: LiveData<List<Budget>> = repo.getAllBudget().asLiveData().map {
        it.sortedBy { it.date }
    }
    val budgets = allBudgets.map {
        it.filter {
            it.date.getStringMonth() == state.get<String>("month")
        }.map {
            BudgetItem(
                it.id,
                it.name,
                it.type,
                it.sum,
                SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(it.date)
            )
        }
    }

}
