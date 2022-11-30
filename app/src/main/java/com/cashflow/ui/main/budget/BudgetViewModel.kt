package com.cashflow.ui.main.budget

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import com.cashflow.data.enums.BudgetType
import com.cashflow.data.general.Budget
import com.cashflow.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(repo: GeneralRepo) : ViewModel() {

    val budgets: LiveData<List<Budget>> = repo.getAllBudget().asLiveData()

    val monthBudgetList = budgets.map {
        it.sortedBy {
            it.date
        }.groupBy {
            it.date.getStringMonth()
        }.map {
            MonthBudgetItem(it.key,
                it.value.sumOf {
                    if (it.type == BudgetType.INCOME) it.sum else 0
                },
                it.value.sumOf {
                    if (it.type == BudgetType.EXPENSE) it.sum else 0
                })
        }
    }
}

fun Date.getStringMonth(): String {
    return SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(this)
}
