package com.mityaalim.data.general

import com.mityaalim.data.enums.BudgetType
import java.util.*

data class Budget (
    val id: String,
    val name: String,
    val type: BudgetType,
    val sum: Int,
    val date: Date
    )
