package com.mityaalim.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mityaalim.data.local.database.entities.budget.BudgetDao
import com.mityaalim.data.local.database.entities.budget.BudgetEntity
import com.mityaalim.data.local.database.entities.event.EventDao
import com.mityaalim.data.local.database.entities.event.EventEntity

private const val DB_NAME = "mityaalim_database"

@Database(
    entities = [
        BudgetEntity::class,
        EventEntity::class
    ],
    version = 1
)
abstract class MityaalimDatabase : RoomDatabase() {

    abstract fun budgetDao(): BudgetDao
    abstract fun eventDao(): EventDao

    companion object {
        fun create(context: Context): MityaalimDatabase {
            return Room.databaseBuilder(
                context,
                MityaalimDatabase::class.java,
                DB_NAME
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
}