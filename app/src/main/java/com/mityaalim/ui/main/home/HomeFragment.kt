package com.mityaalim.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mityaalim.R
import com.mityaalim.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import java.time.DayOfWeek
import java.time.LocalDateTime

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

        binding.tipContent.text = when(LocalDateTime.now().dayOfWeek){
            DayOfWeek.SUNDAY-> getString(R.string.the_first_tip)
            DayOfWeek.MONDAY-> getString(R.string.the_second_tip)
            DayOfWeek.TUESDAY-> getString(R.string.the_third_tip)
            DayOfWeek.WEDNESDAY-> getString(R.string.the_fourth_tip)
            DayOfWeek.THURSDAY-> getString(R.string.the_fifth_tip)
            DayOfWeek.FRIDAY-> getString(R.string.the_sixth_tip)
            DayOfWeek.SATURDAY -> getString(R.string.the_seventh_tip)
        }
    }
}