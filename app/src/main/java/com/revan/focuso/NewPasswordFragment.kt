package com.revan.focuso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.revan.focuso.databinding.FragmentNewPasswordBinding

class NewPasswordFragment : Fragment() {
    private var _binding : FragmentNewPasswordBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupClicks()
    }

    private fun setupClicks() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.saveNewPasswordButton.setOnClickListener {
            safeSaveNewPassword()
        }
    }

    private fun safeSaveNewPassword() {
        val newPassword = binding.passwordEditText.text.toString()
        val repeatedPassword = binding.confirmPasswordEditText.text.toString()

        if (newPassword.length >= 8) {
            binding.passwordTextInputLayout.error = null
            if (newPassword == repeatedPassword) {
                binding.confirmPasswordTextInputLayout.error = null
                findNavController()
                    .navigate(R.id.action_newPasswordFragment_to_passwordUpdatedFragment,
                        null, NavOptions
                            .Builder()
                            .setPopUpTo(R.id.main_nav,true)
                            .build())
            } else {
                binding.confirmPasswordTextInputLayout.error = "Passwords do not match"
            }
        } else {
            binding.passwordTextInputLayout.error = "Password must be at least 8 characters long"
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}