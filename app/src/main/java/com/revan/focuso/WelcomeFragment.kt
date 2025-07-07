package com.revan.focuso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.revan.focuso.databinding.FragmentWelcomeBinding
import com.shashank.sony.fancytoastlib.FancyToast

class WelcomeFragment : Fragment() {
    private var _binding : FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    private var toast : Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initToast()
        setupClicks()
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

    private fun setupClicks() {
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_signUpFragment)
        }

        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment)
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

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}