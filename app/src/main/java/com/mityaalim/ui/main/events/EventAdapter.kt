package com.mityaalim.ui.main.events

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mityaalim.databinding.ItemEventBinding
import com.maatayim.koren.ui.base.list.BaseListAdapter

class EventAdapter(private val addEventListener: (event: EventItem) -> Unit) :
    BaseListAdapter<EventItem, EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            ItemEventBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            addEventListener
        )
    }
}