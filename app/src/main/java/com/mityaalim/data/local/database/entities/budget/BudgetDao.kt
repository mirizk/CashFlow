package com.mityaalim.data.local.database.entities.budget

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {

    @Insert
    fun insertBudget(budget: BudgetEntity)

    @Delete
    fun deleteBudget(budget: BudgetEntity)

    @Query("SELECT * FROM BudgetEntity")
    fun getAllBudget(): Flow<List<BudgetEntity>>
}