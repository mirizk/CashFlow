package com.mityaalim.ui.main.investment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
}