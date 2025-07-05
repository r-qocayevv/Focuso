package com.revan.focuso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.revan.focuso.databinding.OnboardingItemBinding

class OnboardingAdapter(val onboardingItem: List<OnboardingItem>) :
    RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {
    class OnboardingViewHolder(val binding: OnboardingItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val onboardingItemBinding =
            OnboardingItemBinding.inflate(layoutInflater,parent,false)
        return OnboardingViewHolder(onboardingItemBinding)
    }

    override fun onBindViewHolder(
        holder: OnboardingViewHolder,
        position: Int
    ) {
        val binding = holder.binding
        val currentItem = onboardingItem[position]

        binding.titleText.text = currentItem.title
        binding.descriptionText.text = currentItem.description

    }

    override fun getItemCount(): Int {
        return onboardingItem.size
    }
}