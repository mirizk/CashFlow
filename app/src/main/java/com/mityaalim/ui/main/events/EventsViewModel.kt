package com.mityaalim.ui.main.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mityaalim.data.general.Event
import com.mityaalim.data.repo.GeneralRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(private val repo: GeneralRepo) : ViewModel() {

    val events: LiveData<List<Event>> = repo.getAllEvents()

    fun start(){
        viewModelScope.launch(Dispatchers.IO) {
        repo.fetchAllEvents()
    }}
}