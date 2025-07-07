package com.revan.focuso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.revan.focuso.databinding.FragmentSignUpBinding
import com.revan.focuso.util.isValidEmail
import com.shashank.sony.fancytoastlib.FancyToast

class SignUpFragment : Fragment() {
    private var _binding : FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private var toast: Toast? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupClicks()
        initToast()
    }

    private fun setupClicks() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
        binding.signUpButton.setOnClickListener {
            safeSignUp()
        }
        binding.continueWithAppleButton.setOnClickListener {
            toast?.show()
        }
        binding.continueWithFacebookButton.setOnClickListener {
            toast?.show()
        }
        binding.continueWithGoogleButton.setOnClickListener {
            toast?.show()
        }
        binding.continueWithXButton.setOnClickListener {
            toast?.show()
        }
    }

    private fun initToast() {
        toast?.cancel()
        toast = FancyToast.makeText(
            requireContext(),
            getString(R.string.coming_soon),
            FancyToast.LENGTH_SHORT,
            FancyToast.DEFAULT,
            false
        )
    }

    private fun safeSignUp() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val checkBox = binding.checkBox.isChecked

        if (email.isValidEmail()) {
            binding.emailTextInputLayout.error = null
            if (password.length >= 8) {
                binding.passwordTextInputLayout.error = null
                if (checkBox) {
                    //Navigate
                } else {
                    toast?.cancel()
                    toast = FancyToast.makeText(
                        requireContext(),
                        getString(R.string.please_agree_to_terms_and_conditions),
                        FancyToast.LENGTH_SHORT,
                        FancyToast.ERROR, false
                    )
                    toast?.show()
                }
            } else {
                binding.passwordTextInputLayout.error =
                    getString(R.string.invalid_password)
            }
        } else {
            binding.emailTextInputLayout.error = getString(R.string.invalid_email)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}