package com.mityaalim.ui.main.budget.budgetDetails

import com.maatayim.koren.ui.base.list.BaseListItem
import com.mityaalim.data.enums.BudgetType

data class BudgetItem(
    val id: String,
    val name: String,
    val type: BudgetType,
    val sum: Int,
    val date: String
) : BaseListItem<BudgetItem> {
    override fun areItemsTheSame(newItem: BudgetItem): Boolean {
        return id == newItem.id
    }

    override fun isContentTheSame(newItem: BudgetItem): Boolean {
        return name == newItem.name &&
                type == newItem.type &&
                sum == newItem.sum &&
                date == newItem.date
    }
}