package com.mityaalim.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mityaalim.data.local.database.entities.budget.BudgetDao
import com.mityaalim.data.local.database.entities.budget.BudgetEntity

private const val DB_NAME = "mityaalim_database"

@Database(
    entities = [
        BudgetEntity::class
    ],
    version = 1
)
abstract class MityaalimDatabase: RoomDatabase() {

    abstract fun budgetDao(): BudgetDao

    companion object{
        fun create(context: Context): MityaalimDatabase{
         return Room.databaseBuilder(
             context,
             MityaalimDatabase::class.java,
             DB_NAME
         ).fallbackToDestructiveMigration()
             .build()
        }
    }
}