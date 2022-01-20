package com.example.lowesweatherapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lowesweatherapp.R
import com.example.lowesweatherapp.databinding.LookupFragmentBinding

class LookupFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()

    private var _binding: LookupFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = LookupFragmentBinding.inflate(inflater, container, false).apply {
        _binding = this
        lookupButton.setOnClickListener(this@LookupFragment::lookupClicked)
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun lookupClicked(view: View) {
        viewModel.getCoordsData(binding.lookupTextfield.text.toString())
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}