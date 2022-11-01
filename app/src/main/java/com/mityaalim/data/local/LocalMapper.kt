package com.mityaalim.data.local

import com.mityaalim.data.enums.BudgetType
import com.mityaalim.data.general.Budget
import com.mityaalim.data.general.Event
import com.mityaalim.data.local.database.entities.budget.BudgetEntity
import com.mityaalim.data.local.database.entities.event.EventEntity
import java.util.*

fun Budget.toLocalEntity() = BudgetEntity(id, name, type.value, sum, date.time)
fun BudgetEntity.toGeneralModel() =
    Budget(id, name, BudgetType.getByValue(type) ?: BudgetType.INCOME, sum, Date(date))

fun Event.toLocalEntity() = EventEntity(id, title, description, time)
fun EventEntity.toGeneralModel() = Event(eventId, title, description, time)