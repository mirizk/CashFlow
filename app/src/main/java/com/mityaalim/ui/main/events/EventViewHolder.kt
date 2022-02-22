package com.mityaalim.ui.main.events

import com.example.mityaalim.databinding.ItemEventBinding
import com.maatayim.koren.ui.base.list.BaseViewHolder

class EventViewHolder(
    private val binding: ItemEventBinding
) : BaseViewHolder<EventItem>(binding.root) {
    override fun bind(item: EventItem) {
        binding.eventTitle.text = item.title
        binding.eventDescription.text = item.description
        binding.eventTime.text = item.time
    }
}