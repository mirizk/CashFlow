package com.mityaalim.ui.main.budget.budgetDetails

import com.maatayim.koren.ui.base.list.BaseViewHolder
import com.mityaalim.R
import com.mityaalim.data.enums.BudgetType
import com.mityaalim.databinding.ItemBudgetBinding

class BudgetViewHolder(
    private val binding: ItemBudgetBinding,
    val clickListener: (id: String) -> Unit
) : BaseViewHolder<BudgetItem>(binding.root) {
    private lateinit var item: BudgetItem

    init {
        binding.delete.setOnClickListener {
            clickListener.invoke(item.id)
        }
    }

    override fun bind(item: BudgetItem) {
        this.item = item
        binding.date.text = item.date
        binding.name.text = item.name
        binding.sum.text = item.sum.toString()
        if (item.type == BudgetType.EXPENSE)
            binding.iconType.setImageResource(R.drawable.ic_expense)
        else binding.iconType.setImageResource(R.drawable.ic_income)

    }
}