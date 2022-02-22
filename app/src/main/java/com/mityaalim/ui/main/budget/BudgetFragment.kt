package com.mityaalim.ui.main.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mityaalim.databinding.FragmentBudgetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BudgetFragment : Fragment() {

    private val viewModel: BudgetViewModel by viewModels()

    private lateinit var binding: FragmentBudgetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBudgetBinding.inflate(inflater, container, false)
        return binding.root
    }
}