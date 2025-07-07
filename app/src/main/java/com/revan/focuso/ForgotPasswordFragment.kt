package com.revan.focuso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.revan.focuso.databinding.FragmentForgotPasswordBinding
import com.revan.focuso.util.isValidEmail

class ForgotPasswordFragment : Fragment() {
    private var _binding : FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupClicks()
    }

    private fun setupClicks() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.sendOTPButton.setOnClickListener {
            sendOTP()
        }
    }

    private fun sendOTP() {
        val email = binding.emailEditText.text.toString()

        if (email.isValidEmail()){
            binding.emailTextInputLayout.error = null
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_OTPFragment)
        }else {
            binding.emailTextInputLayout.error = getString(R.string.invalid_email)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}