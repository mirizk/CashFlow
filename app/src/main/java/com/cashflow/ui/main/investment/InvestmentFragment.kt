package com.cashflow.ui.main.investment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.cashflow.data.general.Investment
import com.cashflow.databinding.FragmentInvestmentBinding
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
            val adapter = ServiceAdapter({
                findNavController().navigate(InvestmentFragmentDirections.actionInvestmentFragmentToInvestmentDetailsFragment(it))
            })
            val layoutManager = GridLayoutManager(context, 2)
            binding.servicesRecyclerview.adapter = adapter
            binding.servicesRecyclerview.layoutManager = layoutManager
            adapter.submitList(it?.convertToView())

        }

        binding.economicNews.setOnClickListener {
            val uri = Uri.parse("https://www.calcalist.co.il/home/0,7340,L-3704-504,00.html")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private fun List<Investment>.convertToView(): List<ServiceItem> {
        return map {
            ServiceItem(it.id, it.title, it.description, it.price, it.imageUrl) }
    }
}