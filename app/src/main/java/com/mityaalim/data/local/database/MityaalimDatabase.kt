package com.mityaalim.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mityaalim.data.local.database.entities.budget.BudgetDao
import com.mityaalim.data.local.database.entities.budget.BudgetEntity

@Database(
    entities = [
        BudgetEntity::class
    ],
    version = 1
)
abstract class MityaalimDatabase: RoomDatabase() {

    abstract fun budgetDao(): BudgetDao
}