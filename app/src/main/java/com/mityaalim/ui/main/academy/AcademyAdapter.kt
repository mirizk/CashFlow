package com.mityaalim.ui.main.academy

import android.view.LayoutInflater
import android.view.ViewGroup
import com.maatayim.koren.ui.base.list.BaseListAdapter
import com.mityaalim.databinding.ItemAcademyBinding

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