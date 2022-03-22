package com.mityaalim.ui.main.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mityaalim.databinding.FragmentAcademyBinding
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
}