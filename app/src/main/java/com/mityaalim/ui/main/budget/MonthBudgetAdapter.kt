package com.mityaalim.ui.main.budget

import android.view.LayoutInflater
import android.view.ViewGroup
import com.maatayim.koren.ui.base.list.BaseListAdapter
import com.mityaalim.databinding.ItemMonthBudgetBinding

class MonthBudgetAdapter :
    BaseListAdapter<MonthBudgetItem, MonthBudgetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthBudgetViewHolder {
        return MonthBudgetViewHolder(
            ItemMonthBudgetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}