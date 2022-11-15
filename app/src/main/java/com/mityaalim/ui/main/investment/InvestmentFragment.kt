package com.mityaalim.ui.main.investment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mityaalim.data.general.Investment
import com.mityaalim.databinding.FragmentInvestmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InvestmentFragment : Fragment() {

    private val viewModel: InvestmentViewModel by viewModels()

    private lateinit var binding: FragmentInvestmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.services.observe(viewLifecycleOwner) {
            val adapter = ServiceAdapter()
            val layoutManager = GridLayoutManager(context, 2)
            binding.servicesRecyclerview.adapter = adapter
            binding.servicesRecyclerview.layoutManager = layoutManager
            adapter.submitList(it?.convertToView())

        }
    }

    private fun List<Investment>.convertToView(): List<ServiceItem> {
        return map {
            ServiceItem(it.id, it.title, it.description, it.price, it.imageUrl) }
    }
}