package com.mityaalim.ui.main.budget

import android.util.Log
import android.view.View
import com.maatayim.koren.ui.base.list.BaseViewHolder
import com.mityaalim.databinding.ItemMonthBudgetBinding

class MonthBudgetViewHolder(
    private val binding: ItemMonthBudgetBinding
) : BaseViewHolder<MonthBudgetItem>(binding.root) {
    override fun bind(item: MonthBudgetItem) {

        Log.d("miri", "${item.month}: incomes ${item.incomes}. expenses ${item.expenses}")
        binding.incomes.layoutParams.height = ((item.incomes.toDouble() / 10).toInt())
        binding.expenses.layoutParams.height = ((item.expenses.toDouble() / 10).toInt())

        if (binding.incomes.layoutParams.height == 0)
            binding.incomes.visibility = View.INVISIBLE
        if (binding.expenses.layoutParams.height == 0)
            binding.expenses.visibility = View.INVISIBLE
        binding.month.text = item.month
        binding.total.text = (item.incomes - item.expenses).toString()
    }
}