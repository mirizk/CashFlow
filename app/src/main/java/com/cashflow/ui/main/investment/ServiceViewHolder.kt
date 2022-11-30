package com.cashflow.ui.main.investment

import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.maatayim.koren.ui.base.list.BaseViewHolder
import com.cashflow.databinding.ItemServiceBinding

class ServiceViewHolder(
    private val binding: ItemServiceBinding,
    clickListener: (investmentId: String) -> Unit
) : BaseViewHolder<ServiceItem>(binding.root) {
    private lateinit var item: ServiceItem
    init {
        binding.accession.setOnClickListener {
            clickListener.invoke(item.id)
        }
    }
    override fun bind(item: ServiceItem) {
        this.item = item
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