package com.cashflow.ui.main.academy

import android.view.LayoutInflater
import android.view.ViewGroup
import com.maatayim.koren.ui.base.list.BaseListAdapter
import com.cashflow.databinding.ItemAcademyBinding

class AcademyAdapter(private val clickListener: (academyId: String) -> Unit) :
    BaseListAdapter<AcademyItem, AcademyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        return AcademyViewHolder(
            ItemAcademyBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            clickListener
        )
    }
}