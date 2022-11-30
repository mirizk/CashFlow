package com.cashflow.ui.main.home

import androidx.lifecycle.ViewModel
import com.cashflow.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: GeneralRepo) : ViewModel() {
}