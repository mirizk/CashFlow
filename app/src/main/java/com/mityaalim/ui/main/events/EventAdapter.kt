package com.mityaalim.ui.main.events

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mityaalim.databinding.ItemEventBinding
import com.maatayim.koren.ui.base.list.BaseListAdapter

class EventAdapter :
    BaseListAdapter<EventItem, EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            ItemEventBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}