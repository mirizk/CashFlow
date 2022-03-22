package com.mityaalim.data.local.database.entities.budget

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class BudgetEntity(
    @PrimaryKey val id: String,
    val name: String,
    val type: Int,
    val sum: Int,
    val date: Long
)