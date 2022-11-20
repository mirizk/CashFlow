package com.mityaalim.ui.main.academy

import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.maatayim.koren.ui.base.list.BaseViewHolder
import com.mityaalim.databinding.ItemAcademyBinding

class AcademyViewHolder(
    private val binding: ItemAcademyBinding,
    clickListener: (academyId: String) -> Unit
) : BaseViewHolder<AcademyItem>(binding.root) {
    private lateinit var item: AcademyItem
    init {
        binding.root.setOnClickListener {
            item.videoUrl?.let { it1 -> clickListener.invoke(it1) }
        }
    }
    override fun bind(item: AcademyItem) {
        this.item = item
        binding.title.text = item.title
        item.duration?.let {
            binding.duration.text = it.toString()
        }
        item.imageUrl?.let {
            Glide
                .with(binding.root.context)
                .load(it)
                .transform(
                    MultiTransformation(
                        CenterCrop()
                    ),
                    RoundedCorners(30)
                )
                .into(binding.image)
        }
    }
}