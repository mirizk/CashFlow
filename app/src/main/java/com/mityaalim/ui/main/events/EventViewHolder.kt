package com.mityaalim.ui.main.events

import com.mityaalim.databinding.ItemEventBinding
import com.maatayim.koren.ui.base.list.BaseViewHolder
import java.text.SimpleDateFormat

class EventViewHolder(
    private val binding: ItemEventBinding,
    addEventListener: (event: EventItem) -> Unit
) : BaseViewHolder<EventItem>(binding.root) {
    private lateinit var item: EventItem
    init {
        binding.root.setOnClickListener {
            addEventListener.invoke(item)
        }
    }
    override fun bind(item: EventItem) {
        this.item = item
        binding.eventTitle.text = item.title
        binding.eventDescription.text = item.description

        val dateFormated = item.time?.toDate()?.let { SimpleDateFormat("dd/MM/yyyy  HH:ss").format(it) }
        binding.eventTime.text = dateFormated
        binding.eventLocation.text=item.location
    }
}