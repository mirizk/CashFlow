package com.mityaalim.ui.main.budget.budgetDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mityaalim.databinding.FragmentBudgetDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BudgetDetailsFragment : Fragment() {

    private val viewModel: BudgetDetailsViewModel by viewModels()

    private lateinit var binding: FragmentBudgetDetailsBinding
    val args: BudgetDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBudgetDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.title.text = args.month

        viewModel.budgets.observe(viewLifecycleOwner){
            val adapter = BudgetAdapter({
                viewModel.deleteBudget(it)
            })
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager = layoutManager
            adapter.submitList(it)
        }
    }
}