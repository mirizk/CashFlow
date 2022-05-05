package com.mityaalim.ui.main.investment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mityaalim.data.repo.GeneralRepo
import com.mityaalim.ui.main.events.EventItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InvestmentViewModel @Inject constructor(private val repo: GeneralRepo) : ViewModel() {
    val services: LiveData<List<ServiceItem>> = repo.getAllServices()

}