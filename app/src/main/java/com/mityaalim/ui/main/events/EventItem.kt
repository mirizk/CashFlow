package com.mityaalim.ui.main.events

import com.maatayim.koren.ui.base.list.BaseListItem

data class EventItem(
    val id: String,
    val title: String,
    val description: String,
    val time: String
) : BaseListItem<EventItem> {
    override fun areItemsTheSame(newItem: EventItem): Boolean {
        return id == newItem.id
    }

    override fun isContentTheSame(newItem: EventItem): Boolean {
        return title == newItem.title &&
                description == newItem.description &&
                time == newItem.time
    }
}