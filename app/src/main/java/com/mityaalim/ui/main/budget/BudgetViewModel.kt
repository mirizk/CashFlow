package com.mityaalim.ui.main.budget

import androidx.lifecycle.ViewModel
import com.mityaalim.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(private val repo: GeneralRepo) : ViewModel() {
}