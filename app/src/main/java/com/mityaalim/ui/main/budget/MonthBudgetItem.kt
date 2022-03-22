package com.mityaalim.ui.main.budget

import com.maatayim.koren.ui.base.list.BaseListItem

data class MonthBudgetItem(
    val month: String,
    val incomes: Int,
    val expenses: Int
) : BaseListItem<MonthBudgetItem> {
    override fun areItemsTheSame(newItem: MonthBudgetItem): Boolean {
        return month == newItem.month
    }

    override fun isContentTheSame(newItem: MonthBudgetItem): Boolean {
        return incomes == newItem.incomes &&
                expenses == newItem.expenses
    }
}