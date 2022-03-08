package com.mityaalim.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mityaalim.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.academyBackground.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAcademyFragment())
        }
        binding.budgetBackground.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToBudgetFragment())
        }
        binding.eventsBackground.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEventsFragment())
        }
        binding.investmentBackground.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToInvestmentFragment())
        }
    }
}