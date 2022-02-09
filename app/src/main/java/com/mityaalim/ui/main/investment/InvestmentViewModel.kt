package com.mityaalim.ui.main.investment

import androidx.lifecycle.ViewModel
import com.mityaalim.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InvestmentViewModel @Inject constructor(private val repo: GeneralRepo) : ViewModel() {
}