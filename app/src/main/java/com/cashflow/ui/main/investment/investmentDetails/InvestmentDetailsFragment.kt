package com.cashflow.ui.main.investment.investmentDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.cashflow.databinding.FragmentInvestmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InvestmentDetailsFragment: Fragment() {

    private val viewModel: InvestmentDetailsViewModel by viewModels()

    private lateinit var binding: FragmentInvestmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInvestmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.service.observe(viewLifecycleOwner){ investment->
            binding.title.text = investment?.title
            binding.description.text = investment?.description
            investment?.imageUrl?.let {
                Glide
                    .with(binding.root.context)
                    .load(it)
                    .transform(
                        MultiTransformation(
                            CenterCrop()
                        )
                    )
                    .into(binding.background)
            }
            binding.payment.setOnClickListener {
                investment?.price?.let { price ->
                findNavController().navigate(
                    InvestmentDetailsFragmentDirections.actionInvestmentDetailsFragmentToPaymentFragment(price) )}
            }
        }
    }
}