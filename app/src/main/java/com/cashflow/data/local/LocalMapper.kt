package com.cashflow.data.local

import com.cashflow.data.enums.BudgetType
import com.cashflow.data.general.Budget
import com.cashflow.data.local.database.entities.budget.BudgetEntity
import java.util.*

fun Budget.toLocalEntity() = BudgetEntity(id, name, type.value, sum, date.time)
fun BudgetEntity.toGeneralModel() =
    Budget(id, name, BudgetType.getByValue(type) ?: BudgetType.INCOME, sum, Date(date))
