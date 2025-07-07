package com.revan.focuso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.revan.focuso.databinding.FragmentSignInBinding
import com.revan.focuso.util.isValidEmail
import com.shashank.sony.fancytoastlib.FancyToast

class SignInFragment : Fragment() {
    private var _binding : FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private var toast : Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(layoutInflater)
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

        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.forgotPasswordButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
        }
        binding.signInButton.setOnClickListener {
            safeSignIn()
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

    private fun safeSignIn() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if (email.isValidEmail()) {
            binding.emailTextInputLayout.error = null
            if (password.length >= 8) {
                binding.passwordTextInputLayout.error = null
                //Navigate main page
            } else {
                binding.passwordTextInputLayout.error =
                    "Password must be at least 8 characters long"
            }
        } else {
            binding.emailTextInputLayout.error = "Please enter a valid email address"
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}