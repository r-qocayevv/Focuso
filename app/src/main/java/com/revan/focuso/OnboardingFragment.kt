package com.revan.focuso

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.revan.focuso.databinding.FragmentOnboardingBinding
import com.revan.focuso.util.gone
import com.revan.focuso.util.visible


class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get()  = _binding!!
    private var viewPagerPosition = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        setupClicks()
        viewPagerListener()
    }

    private fun viewPagerListener() {
        binding.viewpager
            .registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewPagerPosition = position
                if (viewPagerPosition == 2) {
                    binding.skipBtn.gone()
                    binding.continueBtn.text = "Let's Get Started"
                } else {
                    binding.skipBtn.visible()
                    binding.continueBtn.text = "Continue"
                }
            }
        })
    }

    private fun setupClicks() {
        binding.continueBtn.setOnClickListener {
            if (viewPagerPosition == 2) {
                findNavController()
                    .navigate(R.id.action_onboardingFragment_to_welcomeFragment)
            }else {
                binding.viewpager.currentItem = viewPagerPosition + 1
            }
        }

        binding.skipBtn.setOnClickListener {
            //Navigate welcome screen
            findNavController().navigate(R.id.action_onboardingFragment_to_welcomeFragment)
        }
    }

    private fun setAdapter() {
        val onboardingItems = listOf(
            OnboardingItem(
                "Stay Focused, One Pomodoro at a Time",
                "Break your work into focused sessions with built-in breaks. Boost productivity. reduce burnout, and get more done —mindfully.",
                R.drawable.focuso_logo
            ),
            OnboardingItem(
                "Tasks, Tags & Projects - All in One Place",
                "Plan your work, organize tasks by tags and projects, and track your progress with ease. Stay structured. even on busy days.",
                R.drawable.ic_launcher_foreground
            ),
            OnboardingItem(
                "Visualize Your Focus & Growth",
                "See your productivity in calendar views and insightful reports. Reflect on your effort, celebrate your streaks, and stay motivated.",
                R.drawable.ic_launcher_background
            )
        )
        val onboardingAdapter = OnboardingAdapter(onboardingItems)
        val viewpager = binding.viewpager
        viewpager.adapter = onboardingAdapter
        binding.dotsIndicator.attachTo(viewpager)

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}