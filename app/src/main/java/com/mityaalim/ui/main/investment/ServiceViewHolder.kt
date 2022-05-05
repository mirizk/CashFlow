package com.mityaalim.ui.main.investment

import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.maatayim.koren.ui.base.list.BaseViewHolder
import com.mityaalim.R
import com.mityaalim.databinding.ItemServiceBinding

class ServiceViewHolder(
    private val binding: ItemServiceBinding
) : BaseViewHolder<ServiceItem>(binding.root) {
    override fun bind(item: ServiceItem) {
        binding.title.text = item.title
        item.price?.let {
            binding.price.text = it.toString()
        }
        item.imageUrl?.let {
            Glide
                .with(binding.root.context)
                .load(it)
                .transform(
                    MultiTransformation(
                        CenterCrop()
                    )
                )
                .into(binding.image)
        }
    }
}