package com.mityaalim.ui.main.academy

import com.maatayim.koren.ui.base.list.BaseListItem

data class AcademyItem(
    val id: String,
    val title: String? = null,
    val duration: String? = null,
    val imageUrl: String? = null,
    val videoUrl: String? = null
) : BaseListItem<AcademyItem> {
    override fun areItemsTheSame(newItem: AcademyItem): Boolean {
        return id == newItem.id
    }

    override fun isContentTheSame(newItem: AcademyItem): Boolean {
        return title == newItem.title &&
                duration == newItem.duration &&
                imageUrl == newItem.imageUrl &&
                videoUrl == newItem.videoUrl
    }
}