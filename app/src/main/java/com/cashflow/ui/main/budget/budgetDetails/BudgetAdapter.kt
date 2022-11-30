package com.cashflow.ui.main.budget.budgetDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.maatayim.koren.ui.base.list.BaseListAdapter
import com.cashflow.databinding.ItemBudgetBinding

class BudgetAdapter(private val clickListener: (month: String) -> Unit) :
    BaseListAdapter<BudgetItem, BudgetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        return BudgetViewHolder(
            ItemBudgetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            clickListener
        )
    }
}