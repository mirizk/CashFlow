package com.mityaalim.ui.main.budget

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mityaalim.data.enums.BudgetType
import com.mityaalim.databinding.FragmentBudgetBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startActivity( Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS))

        binding.addIncome.setOnClickListener {
            findNavController().navigate(BudgetFragmentDirections.actionBudgetFragmentToAddBudgetFragment(BudgetType.INCOME))
        }
        binding.addExpense.setOnClickListener {
            findNavController().navigate(BudgetFragmentDirections.actionBudgetFragmentToAddBudgetFragment(BudgetType.EXPENSE))
        }

        viewModel.monthBudgetList.observe(viewLifecycleOwner){
            val adapter = MonthBudgetAdapter({
                findNavController().navigate(BudgetFragmentDirections.actionBudgetFragmentToBudgetDetailsFragment(it))
            })
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager = layoutManager
            adapter.submitList(it)
        }
    }
}