package com.revan.focuso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revan.focuso.databinding.FragmentOtpBinding

class OTPFragment : Fragment() {
    private var _binding: FragmentOtpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOtpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupClick()
    }

    private fun setupClick() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}