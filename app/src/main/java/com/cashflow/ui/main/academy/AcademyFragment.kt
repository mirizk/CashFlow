package com.cashflow.ui.main.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cashflow.data.general.Academy
import com.cashflow.databinding.FragmentAcademyBinding
import com.cashflow.ui.main.academy.AcademyAdapter
import com.cashflow.ui.main.academy.AcademyItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AcademyFragment : Fragment() {

    private val viewModel: AcademyViewModel by viewModels()

    private lateinit var binding: FragmentAcademyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAcademyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.allAcademy.observe(viewLifecycleOwner){
            val adapter = AcademyAdapter({
                findNavController().navigate(AcademyFragmentDirections.actionAcademyFragmentToMediaPlayerFragment(it))
            })
//            val layoutManager = GridLayoutManager(context, 2)
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.academyRecyclerview.adapter = adapter
            binding.academyRecyclerview.layoutManager = layoutManager
            adapter.submitList(it?.convertToView())
        }
    }
}

private fun List<Academy>.convertToView(): List<AcademyItem> {
    return map {
        AcademyItem(it.id, it.title, it.duration, it.imageUrl, it.videoUrl )
    }

}
