package com.mityaalim.ui.main.investment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.maatayim.koren.ui.base.list.BaseListAdapter
import com.mityaalim.databinding.ItemServiceBinding

class ServiceAdapter :
    BaseListAdapter<ServiceItem, ServiceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(
            ItemServiceBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}