package com.mityaalim.ui.main.events

import androidx.lifecycle.ViewModel
import com.mityaalim.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AcademyViewModel @Inject constructor(private val repo: GeneralRepo) : ViewModel() {
    val allAcademy = repo.getAcademyLiveData()
}