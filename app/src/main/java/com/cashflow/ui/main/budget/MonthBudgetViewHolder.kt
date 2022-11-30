package com.cashflow.ui.main.budget

import android.view.View
import com.maatayim.koren.ui.base.list.BaseViewHolder
import com.cashflow.databinding.ItemMonthBudgetBinding

class MonthBudgetViewHolder(
    private val binding: ItemMonthBudgetBinding,
    val clickListener: (month: String) -> Unit
) : BaseViewHolder<MonthBudgetItem>(binding.root) {
    private lateinit var item: MonthBudgetItem
    init {
        binding.root.setOnClickListener {
            clickListener.invoke(item.month)
        }
    }

    override fun bind(item: MonthBudgetItem) {
        this.item = item
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