package com.cashflow.data.enums

enum class BudgetType(val value: Int) {
    INCOME(0), EXPENSE(1);

    companion object{
        fun getByValue(value: Int?) = values().firstOrNull { it.value == value }
    }
}
