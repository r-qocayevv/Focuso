package com.revan.focuso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class PasswordUpdatedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password_updated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupClicks()
    }

    private fun setupClicks() {
        val signInButton = view?.findViewById<Button>(R.id.signInButton)
        signInButton?.setOnClickListener {
            findNavController()
                .navigate(R.id.action_passwordUpdatedFragment_to_signInFragment,null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.main_nav,true)
                    .build())
        }

    }
}