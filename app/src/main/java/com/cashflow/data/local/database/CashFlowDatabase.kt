package com.cashflow.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cashflow.data.local.database.entities.budget.BudgetDao
import com.cashflow.data.local.database.entities.budget.BudgetEntity

private const val DB_NAME = "cashflow_database"

@Database(
    entities = [
        BudgetEntity::class,
    ],
    version = 1
)
abstract class CashFlowDatabase : RoomDatabase() {

    abstract fun budgetDao(): BudgetDao

    companion object {
        fun create(context: Context): CashFlowDatabase {
            return Room.databaseBuilder(
                context,
                CashFlowDatabase::class.java,
                DB_NAME
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
}